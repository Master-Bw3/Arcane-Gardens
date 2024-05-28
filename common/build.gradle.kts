import arcanegardens.libs

plugins {
    id("arcanegardens.conventions.architectury")
}

architectury {
    common("fabric", "neoforge")
}

arcaneGardensArchitectury {
    platform("common")
}

dependencies {
    implementation(libs.kotlin.stdlib)
    implementation(kotlin("reflect"))

    // We depend on fabric loader here to use the fabric @Environment annotations and get the mixin dependencies
    // Do NOT use other classes from fabric loader
    modImplementation(libs.fabric.loader)
    modApi(libs.architectury)

    implementation(libs.mixinExtras)

}
