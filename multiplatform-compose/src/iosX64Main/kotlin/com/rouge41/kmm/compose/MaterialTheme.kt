package com.rouge41.kmm.compose

import platform.UIKit.*

actual data class Colors(
    actual var primary: Color,
    actual var primaryVariant: Color,
    actual var secondary: Color,
    actual var secondaryVariant: Color,
    actual var background: Color,
    actual var surface: Color,
    actual var error: Color,
    actual var onPrimary: Color,
    actual var onSecondary: Color,
    actual var onBackground: Color,
    actual var onSurface: Color,
    actual var onError: Color,
    actual var isLight: Boolean,
)

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

actual interface CornerSize

actual abstract class CornerBasedShape(
    actual val topLeft: CornerSize,
    actual val topRight: CornerSize,
    actual val bottomRight: CornerSize,
    actual val bottomLeft: CornerSize
)

class RoundedCornerShape(
    topLeft: CornerSize,
    topRight: CornerSize,
    bottomRight: CornerSize,
    bottomLeft: CornerSize
) : CornerBasedShape(topLeft, topRight, bottomRight, bottomLeft) {
    constructor(dp: Dp): this(dp, dp, dp, dp)
}

actual class Shapes {
    actual val small: CornerBasedShape = RoundedCornerShape(4.dp)
    actual val medium: CornerBasedShape = RoundedCornerShape(4.dp)
    actual val large: CornerBasedShape = RoundedCornerShape(0.dp)
}

actual object MaterialTheme {
    actual val colors: Colors = lightColors()
    actual val typography: Typography = Typography()
    actual val shapes: Shapes = Shapes()
}

@Composable
actual fun MaterialTheme(
        colors: Colors?,
        typography: Typography?,
        shapes: Shapes?,
        content: @Composable () -> Unit
) = content.invoke()

@Composable
actual fun isSystemInDarkTheme(): Boolean {
    return HostingController.host.controller.traitCollection.userInterfaceStyle == UIUserInterfaceStyle.UIUserInterfaceStyleDark
}

actual fun darkColors(
        primary: Color,
        primaryVariant: Color,
        secondary: Color,
        background: Color,
        surface: Color,
        error: Color,
        onPrimary: Color,
        onSecondary: Color,
        onBackground: Color,
        onSurface: Color,
        onError: Color
): Colors = Colors(primary = primary, primaryVariant = primaryVariant, secondary = secondary, secondaryVariant = secondary, background = background,
        surface = surface, error = error, onPrimary = onPrimary, onSecondary = onSecondary, onBackground = onBackground,
        onSurface = onSurface, onError = onError, isLight = false)

actual fun lightColors(
        primary: Color,
        primaryVariant: Color,
        secondary: Color,
        secondaryVariant: Color,
        background: Color,
        surface: Color,
        error: Color,
        onPrimary: Color,
        onSecondary: Color,
        onBackground: Color,
        onSurface: Color,
        onError: Color
): Colors = Colors(primary = primary, primaryVariant = primaryVariant, secondary = secondary, secondaryVariant = secondaryVariant, background = background,
        surface = surface, error = error, onPrimary = onPrimary, onSecondary = onSecondary, onBackground = onBackground,
        onSurface = onSurface, onError = onError, isLight = true)

