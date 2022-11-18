
object Version {
    const val kotlin = "1.7.20"
    const val gradle = "7.3.1"
    const val appcompat = "1.4.0"
    const val material = "1.4.0"
    const val compose = "1.2.1"
    const val compose_compiler = "1.3.2"
    const val precompose = "1.3.9"
    const val ktor = "2.1.2"
}


object AndroidSdk {
    const val min = 21
    const val compile = 33
    const val target = compile
}

object iOSSdk {
    const val deploymentTarget = "10.0"
}

object Android {
    const val appcompat = "androidx.appcompat:appcompat:${Version.appcompat}"
    const val material = "com.google.android.material:material:${Version.material}"
    const val gradle = "com.android.tools.build:gradle:${Version.gradle}"
}

object Compose {
    const val runtime = "androidx.compose.runtime:runtime:${Version.compose}"
    const val ui = "androidx.compose.ui:ui:${Version.compose}"
    const val foundationLayout = "androidx.compose.foundation:foundation-layout:${Version.compose}"
    const val material = "androidx.compose.material:material:${Version.compose}"
}

object Kotlin {
    const val gradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlin}"
    const val serialization = "org.jetbrains.kotlin:kotlin-serialization:${Version.kotlin}"
}

const val precompose = "moe.tlaster:precompose:${Version.precompose}"

object Ktor {
    const val client_core = "io.ktor:ktor-client-core:${Version.ktor}"
    const val client_content_negotiation = "io.ktor:ktor-client-content-negotiation:${Version.ktor}"
    const val client_logging = "io.ktor:ktor-client-logging:${Version.ktor}"
    const val serialization_json = "io.ktor:ktor-serialization-kotlinx-json:${Version.ktor}"
    const val client_logging_jvm = "io.ktor:ktor-client-logging-jvm:${Version.ktor}"
    const val client_json_jvm = "io.ktor:ktor-client-json-jvm:${Version.ktor}"
    const val client_android = "io.ktor:ktor-client-android:${Version.ktor}"
    const val client_ios = "io.ktor:ktor-client-ios:${Version.ktor}"
}
