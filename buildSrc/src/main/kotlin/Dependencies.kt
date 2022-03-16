
object Version {
    const val kotlin = "1.6.10"

    const val appcompat = "1.4.0"
    const val material = "1.4.0"

    const val compose = "1.1.0"
    const val nav_compose = "2.4.1"

    const val yoga = "~> 1.7"

    const val junit = "4.13"

    const val coil = "1.4.0"
    const val coroutines = "1.5.2"
}


object AndroidSdk {
    const val min = 24
    const val compile = 31
    const val target = compile
}

object iOSSdk {
    const val deploymentTarget = "10.0"
}

object Android {
    const val appcompact = "androidx.appcompat:appcompat:${Version.appcompat}"
    const val material = "com.google.android.material:material:${Version.material}"
}

object Compose {
    const val runtime = "androidx.compose.runtime:runtime:${Version.compose}"
    const val ui = "androidx.compose.ui:ui:${Version.compose}"
    const val foundationLayout = "androidx.compose.foundation:foundation-layout:${Version.compose}"
    const val material = "androidx.compose.material:material:${Version.compose}"
    const val runtimeLiveData = "androidx.compose.runtime:runtime-livedata:${Version.compose}"
    const val navigation = "androidx.navigation:navigation-compose:${Version.nav_compose}"
}

object Coil {
    const val coil = "io.coil-kt:coil:${Version.coil}"
}

object Kotlinx {
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutines}"
}