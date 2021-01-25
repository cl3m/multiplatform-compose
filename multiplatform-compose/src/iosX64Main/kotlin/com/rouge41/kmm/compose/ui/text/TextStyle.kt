package com.rouge41.kmm.compose.ui.text

import com.rouge41.kmm.compose.ui.graphics.Shadow
import com.rouge41.kmm.compose.ui.graphics.Color
import com.rouge41.kmm.compose.ui.text.font.FontFamily
import com.rouge41.kmm.compose.ui.text.font.FontStyle
import com.rouge41.kmm.compose.ui.text.font.FontWeight
import com.rouge41.kmm.compose.ui.unit.TextUnit
import platform.CoreGraphics.CGFloat
import platform.UIKit.UIFont
import platform.UIKit.UILabel

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
    fun toUIFont(overrideFontSize: TextUnit? = null,
                 overrideFontWeight: FontWeight? = null,
                 overrideFontStyle: FontStyle? = null,
                 overrideFontFamily: FontFamily? = null): UIFont {
        val size: CGFloat = overrideFontSize?.packedValue?.toDouble() ?: if (fontSize == TextUnit.Unspecified) UILabel.appearance().font.pointSize else fontSize.packedValue.toDouble()
        val weight: CGFloat = overrideFontWeight?.weight?.toDouble() ?: fontWeight?.weight?.toDouble() ?: 0.0
        when (overrideFontStyle ?: fontStyle) {
            FontStyle.Normal -> TODO()
            FontStyle.Italic -> return UIFont.italicSystemFontOfSize(size)
        }
        when (overrideFontFamily ?: fontFamily) {
            FontFamily.Default -> return UIFont.systemFontOfSize(size, weight)
            FontFamily.SansSerif -> return UIFont.systemFontOfSize(size, weight)
            FontFamily.Serif -> return UIFont.fontWithName("Times", size)!!
            FontFamily.Monospace -> return UIFont.monospacedSystemFontOfSize(size, weight)
            FontFamily.Cursive -> return UIFont.fontWithName("Snell Roundhand", size)!!
        }
        return UIFont.systemFontOfSize(size, weight)
    }
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