package arcanegardens.conventions

import arcanegardens.arcaneGardensProperties

// plugin config

abstract class arcaneGardensPlatformExtension(private val project: Project) {
    abstract val developmentConfiguration: Property<String>
    abstract val shadowCommonConfiguration: Property<String>

    private val arcaneGardensArchitectury by lazy {
        project.extensions.getByType<IArcaneGardensArchitecturyExtension>()
    }

    fun platform(platform: String, vararg extraModLoaders: String) = project.run {
        // "inheritance"
        arcaneGardensArchitectury.platform(platform)

        platform.replaceFirstChar(Char::uppercase).also {
            developmentConfiguration.convention("development$it")
            shadowCommonConfiguration.convention("transformProduction$it")
        }

        configurations {
            named(developmentConfiguration.get()) {
                extendsFrom(get("common"))
            }
        }

        dependencies {
            "shadowCommon"(project(":common", shadowCommonConfiguration.get())) { isTransitive = false }
        }

        publishMods {
            modLoaders.addAll(platform, *extraModLoaders)
            displayName = modLoaders.map { values ->
                val loaders = values.joinToString(", ") { it.replaceFirstChar(Char::uppercase) }
                "v${project.version} [$loaders]"
            }
        }
    }
}

val extension = extensions.create<arcaneGardensPlatformExtension>("arcaneGardensPlatform")

// build logic

plugins {
    id("arcanegardens.conventions.architectury")
    id("arcanegardens.utils.mod-dependencies")

    id("com.github.johnrengelman.shadow")
    id("me.modmuss50.mod-publish-plugin")
}

architectury {
    platformSetupLoomIde()
}

configurations {
    register("common")
    register("shadowCommon")
    compileClasspath {
        extendsFrom(get("common"))
    }
    runtimeClasspath {
        extendsFrom(get("common"))
    }
}

dependencies {
    "common"(project(":common", "namedElements")) { isTransitive = false }
}

sourceSets {
    main {
        resources {
            source(project(":common").sourceSets.main.get().resources)
        }
    }
}

tasks {
    shadowJar {
        exclude("architectury.common.json")
        configurations = listOf(project.configurations["shadowCommon"])
        archiveClassifier = "dev-shadow"
    }

    remapJar {
        dependsOn(shadowJar)
        inputFile = shadowJar.get().archiveFile
        archiveClassifier = null
    }

    jar {
        archiveClassifier = "dev"
    }

    kotlinSourcesJar {
        val commonSources = project(":common").tasks.kotlinSourcesJar
        dependsOn(commonSources)
        from(commonSources.flatMap { it.archiveFile }.map(::zipTree))
    }
}

components {
    named<AdhocComponentWithVariants>("java") {
        withVariantsFromConfiguration(configurations.shadowRuntimeElements.get()) {
            skip()
        }
    }
}

fun Project.envOrEmpty(name: String) = this.providers.environmentVariable(name).orElse("")

publishMods {
    dryRun = providers.zip(envOrEmpty("CI"), envOrEmpty("DRY_RUN")) { ci, dryRun ->
        ci.isBlank() || dryRun.isNotBlank()
    }

    type = BETA
    changelog = arcaneGardensProperties.getLatestChangelog()
    file = tasks.remapJar.flatMap { it.archiveFile }

    curseforge {
        accessToken = envOrEmpty("CURSEFORGE_TOKEN")
        projectId = arcaneGardensProperties.curseforgeId
        minecraftVersions.add(arcaneGardensProperties.minecraftVersion)
        clientRequired = true
        serverRequired = true
    }

    modrinth {
        accessToken = envOrEmpty("MODRINTH_TOKEN")
        projectId = arcaneGardensProperties.modrinthId
        minecraftVersions.add(arcaneGardensProperties.minecraftVersion)
    }
}
