package com.rouge41.kmm.compose.material

import com.rouge41.kmm.compose.ui.graphics.Color

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