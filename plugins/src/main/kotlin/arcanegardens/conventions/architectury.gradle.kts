package arcanegardens.conventions

import arcanegardens.arcaneGardensProperties
import arcanegardens.libs
import kotlin.io.path.div

// plugin config

abstract class ArcaneGardensArchitecturyExtension(private val project: Project) : IArcaneGardensArchitecturyExtension {
    override fun platform(platform: String) = project.run {
        val archivesName = "${arcaneGardensProperties.modId}-$platform"

        base.archivesName = archivesName

        publishing {
            publications {
                named<MavenPublication>("maven") {
                    artifactId = archivesName
                }
            }
        }
    }
}

val extension = extensions.create<ArcaneGardensArchitecturyExtension>("arcaneGardensArchitectury")

// build logic

plugins {
    id("arcanegardens.conventions.kotlin")
    id("arcanegardens.utils.OTJFPOPKPCPBP")

    `maven-publish`
    id("dev.architectury.loom")
}

loom {
    silentMojangMappingsLicense()
    accessWidenerPath = project(":common").file("src/main/resources/arcanegardens-common.accesswidener")
}

dependencies {
    minecraft(libs.minecraft)

//    mappings(loom.layered {
//        libs.yarn.mappings
//        libs.yarn.mappings.neoforge
//    })
    mappings(loom.layered {
        officialMojangMappings()
        parchment(libs.parchment)
    })

    annotationProcessor(libs.bundles.asm)
}

sourceSets {
    main {
        kotlin {
            srcDir(file("src/main/java"))
        }
        resources {
            srcDir(file("src/generated/resources"))
        }
    }
}

tasks {
    val jenkinsArtifacts = register<Copy>("jenkinsArtifacts") {
        from(remapJar, remapSourcesJar, get("javadocJar"))
        into(rootDir.toPath() / "build" / "jenkinsArtifacts")
    }

    build {
        dependsOn(jenkinsArtifacts)
    }
}

publishing {
    repositories {
        arcaneGardensProperties.localMavenUrl?.let {
            maven {
                url = it
            }
        }
    }
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}
