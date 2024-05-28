package arcanegardens

import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Project
import org.gradle.kotlin.dsl.the

val Project.libs get() = the<LibrariesForLibs>()

val Project.arcaneGardensProperties get() = ArcaneGardensProperties(this)
