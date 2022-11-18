pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}
rootProject.name = "multiplatform-compose"

include(":androidApp")
include(":test")
