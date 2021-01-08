pluginManagement {
    repositories {
        google()
        jcenter()
        gradlePluginPortal()
        mavenCentral()
    }
    
}
rootProject.name = "multiplatform-compose"


include(":androidApp")
include(":multiplatform-compose")
include(":test")