package com.rouge41.kmm.compose

import platform.CoreGraphics.CGFloat
import platform.UIKit.*

actual data class TextStyle actual constructor(
    actual val color: Color,
    actual val fontSize: TextUnit,
    actual val fontWeight: FontWeight?,
    actual val fontStyle: FontStyle?,
    actual val fontSynthesis: FontSynthesis?,
    actual val fontFamily: FontFamily?,
    actual val fontFeatureSettings: String?,
    actual val letterSpacing: TextUnit,
    actual val baselineShift: BaselineShift?,
    actual val textGeometricTransform: TextGeometricTransform?,
    actual val localeList: LocaleList?,
    actual val background: Color,
    actual val textDecoration: TextDecoration?,
    actual val shadow: Shadow?,
    actual val textAlign: TextAlign?,
    actual val textDirection: TextDirection?,
    actual val lineHeight: TextUnit,
    actual val textIndent: TextIndent?
) {
    fun toUIFont(): UIFont {
        val size: CGFloat = if (fontSize == TextUnit.Unspecified) UILabel.appearance().font.pointSize else fontSize.packedValue.toDouble()
        val weight: CGFloat = fontWeight?.weight?.toDouble() ?: 0.0
        when (fontStyle) {
            FontStyle.Normal -> TODO()
            FontStyle.Italic -> return UIFont.italicSystemFontOfSize(size)
        }
        when (fontFamily) {
            FontFamily.Default -> return UIFont.systemFontOfSize(size, weight)
            FontFamily.SansSerif -> return UIFont.systemFontOfSize(size, weight)
            FontFamily.Serif -> return UIFont.fontWithName("Times", size)!!
            FontFamily.Monospace -> return UIFont.monospacedSystemFontOfSize(size, weight)
            FontFamily.Cursive -> return UIFont.fontWithName("Snell Roundhand", size)!!
        }
        return UIFont.systemFontOfSize(size, weight)
    }
}

actual data class FontWeight(val weight: Int) {
    actual companion object {
        actual val W100 = FontWeight(100)
        actual val W200 = FontWeight(200)
        actual val W300 = FontWeight(300)
        actual val W400 = FontWeight(400)
        actual val W500 = FontWeight(500)
        actual val W600 = FontWeight(600)
        actual val W700 = FontWeight(700)
        actual val W800 = FontWeight(800)
        actual val W900 = FontWeight(900)
        actual val Thin = W100
        actual val ExtraLight = W200
        actual val Light = W300
        actual val Normal = W400
        actual val Medium = W500
        actual val SemiBold = W600
        actual val Bold = W700
        actual val ExtraBold = W800
        actual val Black = W900
    }
}

actual inline class TextUnit(val packedValue: Long) {
    actual companion object {
        actual val Unspecified = TextUnit(Long.MAX_VALUE)
    }
}
actual inline val Int.sp: TextUnit get() = TextUnit(packedValue = this.toLong())

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

actual enum class FontStyle {
    Normal,
    Italic
}

actual class GenericFontFamily(val name: String): SystemFontFamily()
actual sealed class SystemFontFamily: FontFamily() {
    object DefaultFontFamily : SystemFontFamily()
}
actual enum class FontSynthesis {
    None, Weight, Style, All
}

actual inline class BaselineShift actual constructor(actual val multiplier: Float) {
    actual companion object {
        actual val Superscript: BaselineShift
            get() = TODO("Not yet implemented")
        actual val Subscript: BaselineShift
            get() = TODO("Not yet implemented")
        actual val None: BaselineShift
            get() = TODO("Not yet implemented")
    }
}

actual class TextGeometricTransform {
    actual val scaleX: Float
        get() = TODO("Not yet implemented")
    actual val skewX: Float
        get() = TODO("Not yet implemented")

    actual companion object {
        internal actual val None: TextGeometricTransform
            get() = TODO("Not yet implemented")
    }

}

actual class Locale
actual class LocaleList {
    actual val localeList: List<Locale>
        get() = TODO("Not yet implemented")
}

actual class TextDecoration
actual enum class TextAlign {
    Left, Right, Center, Justify, Start, End
}

actual inline class Offset actual constructor(actual val packedValue: Long)
actual class Shadow {
    actual val color: Color
        get() = TODO("Not yet implemented")
    actual val offset: Offset
        get() = TODO("Not yet implemented")
    actual val blurRadius: Float
        get() = TODO("Not yet implemented")

    actual companion object {
        actual val None: Shadow
            get() = TODO("Not yet implemented")
    }
}

actual enum class TextDirection {
    Ltr, Rtl, Content, ContentOrLtr, ContentOrRtl
}

actual class TextIndent {
    actual val firstLine: TextUnit
        get() = TODO("Not yet implemented")
    actual val restLine: TextUnit
        get() = TODO("Not yet implemented")

    actual companion object {
        actual val None: TextIndent
            get() = TODO("Not yet implemented")
    }
}