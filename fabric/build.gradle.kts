plugins {
    id("arcanegardens.conventions.platform")
}

architectury {
    fabric()
}

arcaneGardensPlatform {
    platform("fabric", "quilt")
}

arcaneGardensModDependencies {
    filesMatching.add("fabric.mod.json")

    anyVersion = "*"
    mapVersions {
        replace(",", " ")
        replace(Regex("""\s+"""), " ")
        replace(Regex("""\[(\S+)"""), ">=$1")
        replace(Regex("""(\S+)\]"""), "<=$1")
        replace(Regex("""\](\S+)"""), ">$1")
        replace(Regex("""(\S+)\["""), "<$1")
    }

    requires("architectury-api")

    requires("fabric-api")
    requires("fabric-language-kotlin")
}

dependencies {
    modApi(libs.fabric.api)
    modImplementation(libs.fabric.loader)

    modImplementation(libs.kotlin.fabric)

    modApi(libs.architectury.fabric) {
        // Fix for the "two fabric loaders" loading crash
        exclude(group = "net.fabricmc", module = "fabric-loader")
    }

    libs.mixinExtras.also {
        localRuntime(it)
        include(it)
    }
}

// this fails if we do it for all projects, since the tag already exists :/
// see https://github.com/modmuss50/mod-publish-plugin/issues/3
publishMods {
    github {
        accessToken = providers.environmentVariable("GITHUB_TOKEN").orElse("")
        repository = providers.environmentVariable("GITHUB_REPOSITORY").orElse("")
        commitish = providers.environmentVariable("GITHUB_SHA").orElse("")

        type = STABLE
        displayName = "v${project.version}"
        tagName = "v${project.version}"

        additionalFiles.from(project(":common").tasks.remapJar.get().archiveFile)
    }
}

tasks {
    named("publishGithub") {
        dependsOn(project(":common").tasks.remapJar)
        dependsOn(project(":neoforge").tasks.remapJar)
    }
}
