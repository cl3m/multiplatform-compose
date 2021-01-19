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

    constructor(
        defaultFontFamily: FontFamily = FontFamily.Default,
        h1: TextStyle = TextStyle(
            fontWeight = FontWeight.Light,
            fontSize = 96.sp,
            letterSpacing = (-1.5).sp
        ),
        h2: TextStyle = TextStyle(
            fontWeight = FontWeight.Light,
            fontSize = 60.sp,
            letterSpacing = (-0.5).sp
        ),
        h3: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 48.sp,
            letterSpacing = 0.sp
        ),
        h4: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 34.sp,
            letterSpacing = 0.25.sp
        ),
        h5: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 24.sp,
            letterSpacing = 0.sp
        ),
        h6: TextStyle = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp,
            letterSpacing = 0.15.sp
        ),
        subtitle1: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            letterSpacing = 0.15.sp
        ),
        subtitle2: TextStyle = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            letterSpacing = 0.1.sp
        ),
        body1: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            letterSpacing = 0.5.sp
        ),
        body2: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            letterSpacing = 0.25.sp
        ),
        button: TextStyle = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            letterSpacing = 1.25.sp
        ),
        caption: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            letterSpacing = 0.4.sp
        ),
        overline: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 10.sp,
            letterSpacing = 1.5.sp
        )
    )
}

expect interface CornerSize

expect interface Shape

expect abstract class CornerBasedShape: Shape {
    val topLeft: CornerSize
    val topRight: CornerSize
    val bottomRight: CornerSize
    val bottomLeft: CornerSize
}

expect class RoundedCornerShape: CornerBasedShape

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
    colors: Colors? = null,
    typography: Typography? = null,
    shapes: Shapes? = null,
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

expect fun RoundedCornerShape(size: Dp) : CornerBasedShape