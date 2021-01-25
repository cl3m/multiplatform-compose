package com.rouge41.kmm.compose.material

import com.rouge41.kmm.compose.ui.text.font.FontFamily
import com.rouge41.kmm.compose.ui.text.TextStyle

actual data class Typography(
        actual val h1: TextStyle,
        actual val h2: TextStyle,
        actual val h3: TextStyle,
        actual val h4: TextStyle,
        actual val h5: TextStyle,
        actual val h6: TextStyle,
        actual val subtitle1: TextStyle,
        actual val subtitle2: TextStyle,
        actual val body1: TextStyle,
        actual val body2: TextStyle,
        actual val button: TextStyle,
        actual val caption: TextStyle,
        actual val overline: TextStyle,
) {
    actual constructor(defaultFontFamily: FontFamily,
                       h1: TextStyle,
                       h2: TextStyle,
                       h3: TextStyle,
                       h4: TextStyle,
                       h5: TextStyle,
                       h6: TextStyle,
                       subtitle1: TextStyle,
                       subtitle2: TextStyle,
                       body1: TextStyle,
                       body2: TextStyle,
                       button: TextStyle,
                       caption: TextStyle,
                       overline: TextStyle) :
        this(
        h1 = h1.withDefaultFontFamily(defaultFontFamily),
        h2 = h2.withDefaultFontFamily(defaultFontFamily),
        h3 = h3.withDefaultFontFamily(defaultFontFamily),
        h4 = h4.withDefaultFontFamily(defaultFontFamily),
        h5 = h5.withDefaultFontFamily(defaultFontFamily),
        h6 = h6.withDefaultFontFamily(defaultFontFamily),
        subtitle1 = subtitle1.withDefaultFontFamily(defaultFontFamily),
        subtitle2 = subtitle2.withDefaultFontFamily(defaultFontFamily),
        body1 = body1.withDefaultFontFamily(defaultFontFamily),
        body2 = body2.withDefaultFontFamily(defaultFontFamily),
        button = button.withDefaultFontFamily(defaultFontFamily),
        caption = caption.withDefaultFontFamily(defaultFontFamily),
        overline = overline.withDefaultFontFamily(defaultFontFamily)
        )
}

private fun TextStyle.withDefaultFontFamily(default: FontFamily): TextStyle {
    return if (fontFamily != null) this else copy(fontFamily = default)
}