package com.rouge41.kmm.compose.ui.text

import com.rouge41.kmm.compose.ui.graphics.Shadow
import com.rouge41.kmm.compose.ui.graphics.Color
import com.rouge41.kmm.compose.ui.text.font.FontFamily
import com.rouge41.kmm.compose.ui.text.font.FontStyle
import com.rouge41.kmm.compose.ui.text.font.FontWeight
import com.rouge41.kmm.compose.ui.unit.TextUnit

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