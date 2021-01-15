package com.rouge41.kmm.compose

import platform.UIKit.*

actual interface CornerSize

actual abstract class CornerBasedShape {
    actual val topLeft: CornerSize
        get() = TODO()
    actual val topRight: CornerSize
        get() = TODO()
    actual val bottomRight: CornerSize
        get() = TODO()
    actual val bottomLeft: CornerSize
        get() = TODO()
}


actual object MaterialTheme {
    actual val colors: Colors = Colors()
    actual val typography: Typography = Typography()
    actual val shapes: Shapes = Shapes()
}

actual class Typography {
    actual val h1: TextStyle
        get() = TODO("Not yet implemented")
    actual val h2: TextStyle
        get() = TODO("Not yet implemented")
    actual val h3: TextStyle
        get() = TODO("Not yet implemented")
    actual val h4: TextStyle
        get() = TODO("Not yet implemented")
    actual val h5: TextStyle
        get() = TODO("Not yet implemented")
    actual val h6: TextStyle
        get() = TODO("Not yet implemented")
    actual val subtitle1: TextStyle
        get() = TODO("Not yet implemented")
    actual val subtitle2: TextStyle
        get() = TODO("Not yet implemented")
    actual val body1: TextStyle
        get() = TODO("Not yet implemented")
    actual val body2: TextStyle
        get() = TODO("Not yet implemented")
    actual val button: TextStyle
        get() = TODO("Not yet implemented")
    actual val caption: TextStyle
        get() = TODO("Not yet implemented")
    actual val overline: TextStyle
        get() = TODO("Not yet implemented")
}

actual class Colors {
    actual var primary: Color
        get() = TODO("Not yet implemented")
        set(value) {}
    actual var primaryVariant: Color
        get() = TODO("Not yet implemented")
        set(value) {}
    actual var secondary: Color
        get() = TODO("Not yet implemented")
        set(value) {}
    actual var secondaryVariant: Color
        get() = TODO("Not yet implemented")
        set(value) {}
    actual var background: Color
        get() = TODO("Not yet implemented")
        set(value) {}
    actual var surface: Color
        get() = TODO("Not yet implemented")
        set(value) {}
    actual var error: Color
        get() = TODO("Not yet implemented")
        set(value) {}
    actual var onPrimary: Color
        get() = TODO("Not yet implemented")
        set(value) {}
    actual var onSecondary: Color
        get() = TODO("Not yet implemented")
        set(value) {}
    actual var onBackground: Color
        get() = TODO("Not yet implemented")
        set(value) {}
    actual var onSurface: Color
        get() = TODO("Not yet implemented")
        set(value) {}
    actual var onError: Color
        get() = TODO("Not yet implemented")
        set(value) {}
    actual var isLight: Boolean
        get() = TODO("Not yet implemented")
        set(value) {}
}

actual class Shapes {
    actual val small: CornerBasedShape
        get() = TODO("Not yet implemented")
    actual val medium: CornerBasedShape
        get() = TODO("Not yet implemented")
    actual val large: CornerBasedShape
        get() = TODO("Not yet implemented")
}

actual fun lightColors(primary: Color, primaryVariant: Color, secondary: Color, secondaryVariant: Color, background: Color, surface: Color, error: Color, onPrimary: Color, onSecondary: Color, onBackground: Color, onSurface: Color, onError: Color): Colors {
    return Colors()
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
): Colors {
    return Colors()
}

@Composable
actual fun isSystemInDarkTheme(): Boolean {
    return HostingController.host.controller.traitCollection.userInterfaceStyle == UIUserInterfaceStyle.UIUserInterfaceStyleDark
}

@Composable
@Suppress("ACTUAL_FUNCTION_WITH_DEFAULT_ARGUMENTS")
actual fun MaterialTheme(
    colors: Colors = MaterialTheme.colors,
    typography: Typography = MaterialTheme.typography,
    shapes: Shapes = MaterialTheme.shapes,
    content: @Composable () -> Unit
) {
    content.invoke()
}