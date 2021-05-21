pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}
rootProject.name = "Multiplatform DI sample"

include(":androidApp")
include(":shared")
