import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("kotlinx-serialization")
    id("org.jetbrains.compose") version Version.compose
}

version = "0.0.1"

android {
    compileSdk = AndroidSdk.compile
    defaultConfig {
        minSdk = AndroidSdk.min
        targetSdk = AndroidSdk.target
    }
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
}

kotlin {
    android()
    ios()
    cocoapods {
        summary = "Multiplatform Compose Shared Test Module"
        homepage = "https://github.com/cl3m/multiplatform-compose"
        ios.deploymentTarget = iOSSdk.deploymentTarget
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "test"
            isStatic = true
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Ktor.client_core)
                implementation(Ktor.client_content_negotiation)
                implementation(Ktor.client_logging)
                implementation(Ktor.serialization_json)
                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.runtime)
                api(precompose)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(Ktor.client_logging_jvm)
                implementation(Ktor.client_json_jvm)
                implementation(Ktor.client_android)
            }
        }
        val iosMain by getting {
            dependencies {
                implementation(Ktor.client_ios)
            }
        }
    }
}

kotlin {
    targets.withType<KotlinNativeTarget> {
        binaries.all {
            freeCompilerArgs += "-Xdisable-phases=VerifyBitcode"
        }
    }
}
