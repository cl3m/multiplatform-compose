package com.rouge41.kmm.compose

import platform.CoreGraphics.CGFloat
import platform.UIKit.*

actual data class TextStyle(
    val color: Color? = null,
    val fontSize: TextUnit? = null,
    val fontWeight: FontWeight? = null,
    val fontStyle: FontStyle? = null,
    // val fontSynthesis: FontSynthesis? = null,
    val fontFamily: FontFamily? = null,
    /*val fontFeatureSettings: String? = null,
    val letterSpacing: TextUnit = TextUnit.Unspecified,
    val baselineShift: BaselineShift? = null,
    val textGeometricTransform: TextGeometricTransform? = null,
    val localeList: LocaleList? = null,
    val background: Color = Color.Unspecified,
    val textDecoration: TextDecoration? = null,
    val shadow: Shadow? = null,
    val textAlign: TextAlign? = null,
    val textDirection: TextDirection? = null,
    val lineHeight: TextUnit = TextUnit.Unspecified,
    val textIndent: TextIndent? = null*/
) {
    fun toUIFont(): UIFont {
        val size: CGFloat = fontSize?.packedValue?.toDouble() ?: UILabel.appearance().font.pointSize
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
    companion object {
        val W100 = FontWeight(100)
        val W200 = FontWeight(200)
        val W300 = FontWeight(300)
        val W400 = FontWeight(400)
        val W500 = FontWeight(500)
        val W600 = FontWeight(600)
        val W700 = FontWeight(700)
        val W800 = FontWeight(800)
        val W900 = FontWeight(900)
        val Thin = W100
        val ExtraLight = W200
        val Light = W300
        val Normal = W400
        val Medium = W500
        val SemiBold = W600
        val Bold = W700
        val ExtraBold = W800
        val Black = W900
    }
}

actual inline class TextUnit(val packedValue: Long)
actual inline val Int.sp: TextUnit get() = TextUnit(packedValue = this.toLong())

actual sealed class FontFamily {
    object Default : FontFamily()
    object SansSerif : FontFamily() // San Francisco
    object Serif : FontFamily() // Times
    object Monospace : FontFamily() // Menlo
    object Cursive : FontFamily() // Snell Roundhand
}

actual enum class FontStyle {
    Normal,
    Italic
}
