package com.rouge41.kmm.compose.material

import androidx.compose.material.ExperimentalMaterialApi
import com.rouge41.kmm.compose.foundation.layout.PaddingValues
import com.rouge41.kmm.compose.foundation.layout.RowScope
import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ui.Modifier
import com.rouge41.kmm.compose.ui.graphics.Color
import com.rouge41.kmm.compose.ui.graphics.Shape
import com.rouge41.kmm.compose.ui.unit.dp
import androidx.compose.material.Button as _Button
import androidx.compose.material.ButtonDefaults as _ButtonDefaults

@OptIn(ExperimentalMaterialApi::class)
actual typealias ButtonColors = androidx.compose.material.ButtonColors
actual typealias ButtonDefaults = androidx.compose.material.ButtonDefaults
@OptIn(ExperimentalMaterialApi::class)
actual typealias ButtonElevation = androidx.compose.material.ButtonElevation

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
    elevation: ButtonElevation? = ButtonDefaults.elevation(),
    shape: Shape? = null,
    colors: ButtonColors? = null,
    contentPadding: PaddingValues? = null,
    content: @Composable RowScope.() -> Unit
) {
    _Button(onClick = onClick, modifier = modifier, enabled = enabled,
    elevation = elevation, shape = shape ?: MaterialTheme.shapes.small,
    colors = colors ?: ButtonDefaults.buttonColors(), contentPadding = contentPadding ?: ButtonDefaults.ContentPadding,
    content = content)
}

@Composable
@Suppress("ACTUAL_FUNCTION_WITH_DEFAULT_ARGUMENTS")
actual fun OutlinedButton(
        onClick: () -> Unit,
        modifier: Modifier = Modifier,
        enabled: Boolean = true,
        elevation: ButtonElevation? = null,
        shape: Shape? =  null,
        colors: ButtonColors? = null,
        contentPadding: PaddingValues? = null,
        content: @Composable RowScope.() -> Unit
) = Button(
    onClick = onClick,
    modifier = modifier,
    enabled = enabled,
    elevation = elevation,
    shape = shape ?: MaterialTheme.shapes.small,
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
        elevation: ButtonElevation? = null,
        shape: Shape? = null,
        colors: ButtonColors? = null,
        contentPadding: PaddingValues? = null,
        content: @Composable RowScope.() -> Unit
) = Button(
    onClick = onClick,
    modifier = modifier,
    enabled = enabled,
    elevation = elevation,
    shape = shape ?: MaterialTheme.shapes.small,
    colors = colors ?: ButtonDefaults.textButtonColors(),
    contentPadding = contentPadding ?: ButtonDefaults.TextButtonContentPadding,
    content = content
)