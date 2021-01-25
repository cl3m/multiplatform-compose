package com.rouge41.kmm.compose.ui.text.font

expect sealed class FontFamily {
    companion object {
        val Default: SystemFontFamily
        val SansSerif: GenericFontFamily
        val Serif: GenericFontFamily
        val Monospace: GenericFontFamily
        val Cursive: GenericFontFamily
    }
}

expect class GenericFontFamily: SystemFontFamily
expect sealed class SystemFontFamily: FontFamily