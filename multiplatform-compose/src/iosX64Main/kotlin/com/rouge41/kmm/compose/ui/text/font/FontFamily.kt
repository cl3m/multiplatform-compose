package com.rouge41.kmm.compose.ui.text.font

actual sealed class FontFamily {
    actual companion object {
        actual val SansSerif = GenericFontFamily("sans-serif")
        actual val Serif = GenericFontFamily("serif")
        actual val Monospace = GenericFontFamily("monospace")
        actual val Cursive = GenericFontFamily("cursive")
        actual val Default: SystemFontFamily
            get() = SystemFontFamily.DefaultFontFamily
    }
}

actual class GenericFontFamily(val name: String): SystemFontFamily()
actual sealed class SystemFontFamily: FontFamily() {
    object DefaultFontFamily : SystemFontFamily()
}