package com.rouge41.kmm.compose.material

import com.rouge41.kmm.compose.ui.graphics.Color
import androidx.compose.material.darkColors as _darkColors
import androidx.compose.material.lightColors as _lightColors

actual typealias Colors = androidx.compose.material.Colors

actual fun darkColors(
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
): Colors = _darkColors(primary = primary, primaryVariant = primaryVariant, secondary = secondary, secondaryVariant = secondaryVariant, background = background,
        surface = surface, error = error, onPrimary = onPrimary, onSecondary = onSecondary, onBackground = onBackground,
        onSurface = onSurface, onError = onError)

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
): Colors = _lightColors(primary = primary, primaryVariant = primaryVariant, secondary = secondary, secondaryVariant = secondaryVariant, background = background,
        surface = surface, error = error, onPrimary = onPrimary, onSecondary = onSecondary, onBackground = onBackground,
        onSurface = onSurface, onError = onError)
