plugins {
    id("arcanegardens.conventions.platform")
    id("arcanegardens.utils.kotlin-neoforge-runtime-library")
}

architectury {
    neoForge()
}

loom {
    neoForge {
//        convertAccessWideners = true
//        extraAccessWideners.add(loom.accessWidenerPath.get().asFile.name)

//        mixinConfig("arcanegardens-common.mixins.json", "arcanegardens.mixins.json")
    }

    runs {
        register("commonDatagen") {
            data()
            programArgs(
                "--mod", arcaneGardensProperties.modId,
                "--all",
                // we're using forge to do the common datagen because fabric's datagen kind of sucks
                "--output", project(":common").file("src/generated/resources").absolutePath,
                "--existing", file("src/main/resources").absolutePath,
                "--existing", project(":common").file("src/main/resources").absolutePath,
            )
            property("arcanegardens.apply-datagen-mixin", "true")
        }
    }
}

arcaneGardensPlatform {
    platform("neoForge")
}

arcaneGardensModDependencies {
    filesMatching.add("META-INF/neoforge.mods.toml")

    anyVersion = ""
    mapVersions {
        replace(Regex("""\](\S+)"""), "($1")
        replace(Regex("""(\S+)\["""), "$1)")
    }

    requires("architectury-api")

    requires("kotlin-for-forge")
}

dependencies {
    neoForge(libs.neoforge)
    modApi(libs.architectury.neoforge)

    implementation(libs.kotlin.forge)

    libs.mixinExtras.also {
        localRuntime(it)
        include(it)
    }
}

tasks {
    shadowJar {
        exclude("fabric.mod.json")
    }

    named("runCommonDatagen") {
        doFirst {
            project(":common").delete("src/generated/resources")
        }
    }
}

// SO SO SO SCUFFED.
val publishFile = publishMods.file.get().asFile
project(":fabric").publishMods.github {
    additionalFiles.from(publishFile)
}

