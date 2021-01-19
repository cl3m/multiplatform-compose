package com.rouge41.kmm.compose

import androidx.compose.foundation.isSystemInDarkTheme as _isSystemInDarkTheme
import androidx.compose.material.MaterialTheme as _MaterialTheme
import androidx.compose.material.darkColors as _darkColors
import androidx.compose.material.lightColors as _lightColors
import androidx.compose.foundation.shape.RoundedCornerShape as _RoundedCornerShape

actual typealias Colors = androidx.compose.material.Colors

actual typealias Typography = androidx.compose.material.Typography

actual typealias CornerSize = androidx.compose.foundation.shape.CornerSize
actual typealias CornerBasedShape = androidx.compose.foundation.shape.CornerBasedShape
actual typealias RoundedCornerShape = androidx.compose.foundation.shape.RoundedCornerShape
actual typealias Shapes = androidx.compose.material.Shapes

actual typealias MaterialTheme = androidx.compose.material.MaterialTheme

@Composable
@Suppress("ACTUAL_FUNCTION_WITH_DEFAULT_ARGUMENTS")
actual fun MaterialTheme(
        colors: Colors? = null,
        typography: Typography? = null,
        shapes: Shapes? = null,
        content: @Composable () -> Unit
) = _MaterialTheme(
        colors = colors ?: _MaterialTheme.colors,
        typography = typography ?: _MaterialTheme.typography,
        shapes = shapes ?: _MaterialTheme.shapes,
        content = content)

@Composable
actual fun isSystemInDarkTheme(): Boolean = _isSystemInDarkTheme()

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
): Colors = _darkColors(primary = primary, primaryVariant = primaryVariant, secondary = secondary, background = background,
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

actual fun RoundedCornerShape(size: Dp): CornerBasedShape = _RoundedCornerShape(size)