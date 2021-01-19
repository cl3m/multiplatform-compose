package com.rouge41.kmm.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.InteractionState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Button as _Button
import androidx.compose.material.ButtonDefaults as _ButtonDefaults

@OptIn(ExperimentalMaterialApi::class)
actual typealias ButtonColors = androidx.compose.material.ButtonColors
actual typealias ButtonDefaults = androidx.compose.material.ButtonDefaults
@OptIn(ExperimentalMaterialApi::class)
actual typealias ButtonElevation = androidx.compose.material.ButtonElevation
actual typealias Shape = androidx.compose.ui.graphics.Shape
actual typealias BorderStroke = androidx.compose.foundation.BorderStroke
actual typealias Brush = androidx.compose.ui.graphics.Brush
actual typealias SolidColor = androidx.compose.ui.graphics.SolidColor

@Composable
actual fun ButtonDefaults.buttonColors(backgroundColor: Color): ButtonColors =
    _ButtonDefaults.buttonColors(backgroundColor)

@Composable
actual fun ButtonDefaults.buttonColors(): ButtonColors =
    _ButtonDefaults.buttonColors()

@Composable
actual fun ButtonDefaults.outlinedButtonColors(): ButtonColors =
    _ButtonDefaults.outlinedButtonColors()

@Composable
actual fun ButtonDefaults.textButtonColors(): ButtonColors =
    _ButtonDefaults.textButtonColors()

@Composable
@Suppress("ACTUAL_FUNCTION_WITH_DEFAULT_ARGUMENTS")
actual fun Button(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionState: InteractionState? = null,
    elevation: ButtonElevation? = ButtonDefaults.elevation(),
    shape: Shape? = null,
    border: BorderStroke? = null,
    colors: ButtonColors? = null,
    contentPadding: PaddingValues? = null,
    content: @Composable RowScope.() -> Unit
) {
    _Button(onClick = onClick, modifier = modifier, enabled = enabled,
    elevation = elevation, shape = shape ?: MaterialTheme.shapes.small, border = border,
    colors = colors ?: ButtonDefaults.buttonColors(), contentPadding = contentPadding ?: ButtonDefaults.ContentPadding,
    content = content)
}

@Composable
@Suppress("ACTUAL_FUNCTION_WITH_DEFAULT_ARGUMENTS")
actual fun OutlinedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionState: InteractionState? = null,
    elevation: ButtonElevation? = null,
    shape: Shape? =  null,
    border: BorderStroke? = BorderStroke(1.dp, MaterialTheme.colors.onSurface.copy(alpha = ButtonDefaults.OutlinedBorderOpacity)),
    colors: ButtonColors? = null,
    contentPadding: PaddingValues? = null,
    content: @Composable RowScope.() -> Unit
) = Button(
    onClick = onClick,
    modifier = modifier,
    enabled = enabled,
    interactionState = interactionState,
    elevation = elevation,
    shape = shape ?: MaterialTheme.shapes.small,
    border = border,
    colors = colors ?: ButtonDefaults.outlinedButtonColors(),
    contentPadding = contentPadding ?: ButtonDefaults.ContentPadding,
    content = content
)

@Composable
@Suppress("ACTUAL_FUNCTION_WITH_DEFAULT_ARGUMENTS")
actual fun TextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionState: InteractionState? = null,
    elevation: ButtonElevation? = null,
    shape: Shape? = null,
    border: BorderStroke? = null,
    colors: ButtonColors? = null,
    contentPadding: PaddingValues? = null,
    content: @Composable RowScope.() -> Unit
) = Button(
    onClick = onClick,
    modifier = modifier,
    enabled = enabled,
    interactionState = interactionState,
    elevation = elevation,
    shape = shape ?: MaterialTheme.shapes.small,
    border = border,
    colors = colors ?: ButtonDefaults.textButtonColors(),
    contentPadding = contentPadding ?: ButtonDefaults.TextButtonContentPadding,
    content = content
)