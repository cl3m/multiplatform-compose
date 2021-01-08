package com.rouge41.kmm.compose

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.Modifier
import androidx.compose.material.Button as _Button
import androidx.compose.material.ButtonDefaults as _ButtonDefaults

@OptIn(ExperimentalMaterialApi::class)
actual typealias ButtonColors = androidx.compose.material.ButtonColors
actual typealias ButtonDefaults = androidx.compose.material.ButtonDefaults

@Composable
actual fun ButtonDefaults.buttonColors(backgroundColor: Color): ButtonColors =
    _ButtonDefaults.buttonColors(backgroundColor)

@Composable
actual fun ButtonDefaults.buttonColors(): ButtonColors =
    _ButtonDefaults.buttonColors()

@Composable
actual fun Button(
    onClick: () -> Unit,
    modifier: Modifier,
    colors: ButtonColors,
    content: @Composable RowScope.() -> Unit
) {
    _Button(onClick = onClick, modifier = modifier, colors = colors, content = content)
}

@Composable
actual fun Button(
    onClick: () -> Unit,
    colors: ButtonColors,
    content: @Composable RowScope.() -> Unit
) {
    _Button(onClick = onClick, colors = colors, content = content)
}

@Composable
actual fun Button(
    onClick: () -> Unit,
    content: @Composable RowScope.() -> Unit
) {
    _Button(onClick = onClick, content = content)
}
