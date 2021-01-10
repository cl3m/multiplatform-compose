
object Version {
    const val kotlin = "1.4.21"

    const val appcompat = "1.2.0"
    const val material = "1.2.1"

    const val compose = "1.0.0-alpha09"
    const val nav_compose = "1.0.0-alpha04"

    const val yoga = "~> 1.7"

    const val junit = "4.13"
}


object AndroidSdk {
    const val min = 24
    const val compile = 29
    const val target = compile
}

object iOSSdk {
    const val deploymentTarget = "9.0"
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