import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
}

version = "0.0.1"

android {
    compileSdkVersion(AndroidSdk.compile)
    defaultConfig {
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerVersion = Version.kotlin
        kotlinCompilerExtensionVersion = Version.compose
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
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
    kotlinOptions.useIR = true
}

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
        homepage = "https://github.com/cl3m/multiplatform-compose"
        frameworkName = "test"

        ios.deploymentTarget = iOSSdk.deploymentTarget
        pod("YogaKit") {
            version = Version.yoga
        }
        podfile = project.file("../iosApp/Podfile")
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":multiplatform-compose"))
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
                implementation(Android.material)

                implementation(Compose.runtime)
                implementation(Compose.ui)
                implementation(Compose.foundationLayout)
                implementation(Compose.material)
                implementation(Compose.runtimeLiveData)
                implementation(Compose.navigation)
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:${Version.junit}")
            }
        }
        val iosMain by getting
        val iosTest by getting
    }
}

//workaround (https://github.com/arunkumar9t2/compose_mpp_workaround/tree/patch-1):
configurations {
    create("composeCompiler") {
        isCanBeConsumed = false
    }
}
dependencies {
    "composeCompiler"("androidx.compose.compiler:compiler:${Version.compose}")
}
android {
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
}