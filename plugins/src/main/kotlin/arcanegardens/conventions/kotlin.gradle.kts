package arcanegardens.conventions

import arcanegardens.arcaneGardensProperties

plugins {
    id("arcanegardens.utils.properties")

    java
    kotlin("jvm")
    id("architectury-plugin")
}

repositories {
    mavenCentral()
    maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots/") }
    maven { url = uri("https://jitpack.io") }
    maven { url = uri("https://squiddev.cc/maven") }
    maven { url = uri("https://maven.terraformersmc.com") }
    maven { url = uri("https://maven.terraformersmc.com/releases") }
    maven { url = uri("https://maven.shedaniel.me") }
    maven { url = uri("https://maven.blamejared.com") }
    maven { url = uri("https://maven.jamieswhiteshirt.com/libs-release") } // breaks all snapshot dependencies??
    maven { url = uri("https://mvn.devos.one/snapshots") }
    maven { url = uri("https://maven.ladysnake.org/releases") }
    maven { url = uri("https://thedarkcolour.github.io/KotlinForForge") }
    maven { url = uri("https://maven.theillusivec4.top") }
    maven { url = uri("https://dl.cloudsmith.io/public/geckolib3/geckolib/maven") }
    maven { url = uri("https://maven.parchmentmc.org") }
    maven { url = uri("https://maven.fabricmc.net") }
    maven { url = uri("https://maven.neoforged.net/releases") }


    exclusiveContent {
        forRepository {
            maven { url = uri("https://api.modrinth.com/maven") }
        }
        filter {
            includeGroup("maven.modrinth")
        }
    }
}

//dependencies {
//    testImplementation("org.jetbrains.kotlin:kotlin-test")
//}

arcaneGardensProperties.also { props ->
    group = props.mavenGroup
    version = "${props.modVersion}+${props.minecraftVersion}"
    if (!props.publishMavenRelease) {
        version = "$version-SNAPSHOT"
    }
}

java {
    toolchain.languageVersion = JavaLanguageVersion.of(arcaneGardensProperties.javaVersion)
    withSourcesJar()
    withJavadocJar()
}

kotlin {
    jvmToolchain(arcaneGardensProperties.javaVersion)
}

tasks {
    compileJava {
        options.apply {
            encoding = "UTF-8"
            release = arcaneGardensProperties.javaVersion
        }
    }

    jar {
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    }

    withType<GenerateModuleMetadata>().configureEach {
        enabled = false
    }

    javadoc {
        options {
            this as StandardJavadocDocletOptions
            addStringOption("Xdoclint:none", "-quiet")
        }
    }

    processResources {
        exclude(".cache")
    }

//    test {
//        useJUnitPlatform()
//    }

    processTestResources {
        exclude(".cache")
    }
}
