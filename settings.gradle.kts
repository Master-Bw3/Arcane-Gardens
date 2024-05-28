pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        maven { url = uri("https://maven.architectury.dev/") }
        maven { url = uri("https://maven.fabricmc.net/") }
        maven { url = uri("https://maven.neoforged.net/releases") }
        maven { url = uri("https://maven.blamejared.com/") }
    }

    includeBuild("plugins")
}

rootProject.name = "arcanegardens"

include("common", "fabric", "neoforge")
