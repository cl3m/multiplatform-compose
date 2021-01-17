package com.rouge41.kmm.compose

expect class FontWeight {
    companion object {
        val W100: FontWeight
        val W200: FontWeight
        val W300: FontWeight
        val W400: FontWeight
        val W500: FontWeight
        val W600: FontWeight
        val W700: FontWeight
        val W800: FontWeight
        val W900: FontWeight
        val Thin: FontWeight
        val ExtraLight: FontWeight
        val Light: FontWeight
        val Normal: FontWeight
        val Medium: FontWeight
        val SemiBold: FontWeight
        val Bold: FontWeight
        val ExtraBold: FontWeight
        val Black: FontWeight
    }
}
expect sealed class FontFamily {
    companion object {
        val Default: SystemFontFamily
        val SansSerif: GenericFontFamily
        val Serif: GenericFontFamily
        val Monospace: GenericFontFamily
        val Cursive: GenericFontFamily
    }
}
expect sealed class SystemFontFamily: FontFamily
expect class GenericFontFamily: SystemFontFamily

expect inline class TextUnit(val packedValue: Long) {
    companion object {
        val Unspecified: TextUnit
    }
}

expect enum class FontSynthesis {
    None,
    Weight,
    Style,
    All
}

expect inline class BaselineShift(val multiplier: Float) {
    companion object {
        val Superscript: BaselineShift
        val Subscript: BaselineShift
        val None: BaselineShift
    }
}

expect class TextGeometricTransform {
    val scaleX: Float
    val skewX: Float

    companion object {
        internal val None: TextGeometricTransform
    }
}

expect class Locale

expect class LocaleList {
    val localeList: List<Locale>
}

expect class TextDecoration

expect enum class TextAlign {
    Left,
    Right,
    Center,
    Justify,
    Start,
    End
}

expect inline class Offset(val packedValue: Long)

expect class Shadow {
    val color: Color
    val offset: Offset
    val blurRadius: Float
    companion object {
        val None: Shadow
    }
}

expect enum class TextDirection {
    Ltr,
    Rtl,
    Content,
    ContentOrLtr,
    ContentOrRtl
}

expect class TextIndent {
    val firstLine: TextUnit
    val restLine: TextUnit
    companion object {
        val None: TextIndent
    }
}

expect class TextStyle {
    val color: Color
    val fontSize: TextUnit
    val fontWeight: FontWeight?
    val fontStyle: FontStyle?
    val fontSynthesis: FontSynthesis?
    val fontFamily: FontFamily?
    val fontFeatureSettings: String?
    val letterSpacing: TextUnit
    val baselineShift: BaselineShift?
    val textGeometricTransform: TextGeometricTransform?
    val localeList: LocaleList?
    val background: Color
    val textDecoration: TextDecoration?
    val shadow: Shadow?
    val textAlign: TextAlign?
    val textDirection: TextDirection?
    val lineHeight: TextUnit
    val textIndent: TextIndent?
    constructor(color: Color = Color.Unspecified,
               fontSize: TextUnit = TextUnit.Unspecified,
               fontWeight: FontWeight? = null,
               fontStyle: FontStyle? = null,
               fontSynthesis: FontSynthesis? = null,
               fontFamily: FontFamily? = null,
               fontFeatureSettings: String? = null,
               letterSpacing: TextUnit = TextUnit.Unspecified,
               baselineShift: BaselineShift? = null,
               textGeometricTransform: TextGeometricTransform? = null,
               localeList: LocaleList? = null,
               background: Color = Color.Unspecified,
               textDecoration: TextDecoration? = null,
               shadow: Shadow? = null,
               textAlign: TextAlign? = null,
               textDirection: TextDirection? = null,
               lineHeight: TextUnit = TextUnit.Unspecified,
               textIndent: TextIndent? = null)
}
expect enum class FontStyle {
    Normal,
    Italic,
}

expect val Int.sp: TextUnit
expect val Double.sp: TextUnit
