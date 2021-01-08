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
        // Configure fields required by CocoaPods.
        summary = "KMM Compose Sample Shared Module"
        homepage = "Link to a Kotlin/Native module homepage"

        // You can change the name of the produced framework.
        // By default, it is the name of the Gradle project.
        frameworkName = "MultiplatformCompose"

        ios.deploymentTarget = "9.0"

        pod("YogaKit") {
            version = "~> 1.7"
        }
        podfile = project.file("../iosApp/Podfile")
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
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
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:4.13")
            }
        }
        val iosMain by getting
        val iosTest by getting
    }
}
// https://youtrack.jetbrains.com/issue/KT-38694
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
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
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
    sourceSets {
        getByName("main") {
            java.srcDirs("src/androidMain/kotlin")
            res.srcDirs("src/androidMain/res")
        }
        getByName("test") {
            java.srcDirs("src/androidTest/kotlin")
            res.srcDirs("src/androidTest/res")
        }
    }
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
    kotlinOptions.useIR = true
}