package com.rouge41.kmm.compose

expect class Colors {
    var primary: Color
    var primaryVariant: Color
    var secondary: Color
    var secondaryVariant: Color
    var background: Color
    var surface: Color
    var error: Color
    var onPrimary: Color
    var onSecondary: Color
    var onBackground: Color
    var onSurface: Color
    var onError: Color
    var isLight: Boolean
}

expect class Typography {
    val h1: TextStyle
    val h2: TextStyle
    val h3: TextStyle
    val h4: TextStyle
    val h5: TextStyle
    val h6: TextStyle
    val subtitle1: TextStyle
    val subtitle2: TextStyle
    val body1: TextStyle
    val body2: TextStyle
    val button: TextStyle
    val caption: TextStyle
    val overline: TextStyle
}

expect interface CornerSize

expect abstract class CornerBasedShape {
    val topLeft: CornerSize
    val topRight: CornerSize
    val bottomRight: CornerSize
    val bottomLeft: CornerSize
}

expect class Shapes {
    val small: CornerBasedShape
    val medium: CornerBasedShape
    val large: CornerBasedShape
}

expect object MaterialTheme {
    val colors: Colors
    val typography: Typography
    val shapes: Shapes
}

@Composable
expect fun MaterialTheme(
    colors: Colors,
    typography: Typography,
    shapes: Shapes,
    content: @Composable () -> Unit
)

@Composable
expect fun isSystemInDarkTheme(): Boolean

expect fun darkColors(
    primary: Color = Color(0xFFBB86FCu),
    primaryVariant: Color = Color(0xFF3700B3u),
    secondary: Color = Color(0xFF03DAC6u),
    background: Color = Color(0xFF121212u),
    surface: Color = Color(0xFF121212u),
    error: Color = Color(0xFFCF6679u),
    onPrimary: Color = Color.Black,
    onSecondary: Color = Color.Black,
    onBackground: Color = Color.White,
    onSurface: Color = Color.White,
    onError: Color = Color.Black
): Colors

expect fun lightColors(
    primary: Color = Color(0xFF6200EEu),
    primaryVariant: Color = Color(0xFF3700B3u),
    secondary: Color = Color(0xFF03DAC6u),
    secondaryVariant: Color = Color(0xFF018786u),
    background: Color = Color.White,
    surface: Color = Color.White,
    error: Color = Color(0xFFB00020u),
    onPrimary: Color = Color.White,
    onSecondary: Color = Color.Black,
    onBackground: Color = Color.Black,
    onSurface: Color = Color.Black,
    onError: Color = Color.White
): Colors