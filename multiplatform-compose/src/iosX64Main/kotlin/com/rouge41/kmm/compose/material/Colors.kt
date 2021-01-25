package com.rouge41.kmm.compose.material

import com.rouge41.kmm.compose.ui.graphics.Color

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