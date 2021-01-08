import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
}

version = "0.0.1"
val composeVersion:String by project

// workaround for https://youtrack.jetbrains.com/issue/KT-43944
android {
    configurations {
        create("androidTestApi")
        create("androidTestDebugApi")
        create("androidTestReleaseApi")
        create("testApi")
        create("testDebugApi")
        create("testReleaseApi")
    }
}

kotlin {
    android()
    ios ()
    cocoapods {
        summary = "Multiplatform Compose Shared Test Module"
        homepage = "Link to a Kotlin/Native module homepage"
        frameworkName = "test"
        pod("YogaKit") {
            version = "~> 1.7"
        }
        ios.deploymentTarget = "9.0"
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":multiplatform-compose"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("com.google.android.material:material:1.2.1")
                // Compose
                implementation("androidx.compose.runtime:runtime:$composeVersion")
                implementation("androidx.compose.ui:ui:$composeVersion")
                implementation("androidx.compose.foundation:foundation:$composeVersion")
                implementation("androidx.compose.foundation:foundation-layout:$composeVersion")
                implementation("androidx.compose.material:material:$composeVersion")
                implementation("androidx.compose.runtime:runtime-livedata:$composeVersion")
                //implementation("androidx.ui:ui-tooling:$composeVersion")
                implementation("com.google.android.material:compose-theme-adapter:$composeVersion")
                implementation("androidx.navigation:navigation-compose:1.0.0-alpha04")
            }
        }
        val iosMain by getting
    }
}
//workaround (https://github.com/arunkumar9t2/compose_mpp_workaround/tree/patch-1):
configurations {
    create("composeCompiler") {
        isCanBeConsumed = false
    }
}
dependencies {
    "composeCompiler"("androidx.compose.compiler:compiler:$composeVersion")
}
android {
    compileSdkVersion(29)
    defaultConfig {
        minSdkVersion(24)
        targetSdkVersion(29)
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerVersion = "1.4.21"
        kotlinCompilerExtensionVersion = composeVersion
    }
    afterEvaluate {
        val composeCompilerJar =
            configurations["composeCompiler"]
                .resolve()
                .singleOrNull()
                ?: error("Please add \"androidx.compose:compose-compiler\" (and only that) as a \"composeCompiler\" dependency")
        tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
            kotlinOptions.freeCompilerArgs += listOf("-Xuse-ir", "-Xplugin=$composeCompilerJar")
        }
    }
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
    kotlinOptions.useIR = true
}