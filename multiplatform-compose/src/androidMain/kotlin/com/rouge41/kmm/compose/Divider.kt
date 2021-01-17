package com.rouge41.kmm.compose

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Divider as _Divider

@Composable
@Suppress("ACTUAL_FUNCTION_WITH_DEFAULT_ARGUMENTS")
actual fun Divider(
    modifier: Modifier = Modifier,
    color: Color? = null,
    thickness: Dp = 1.dp,
    startIndent: Dp = 0.dp
) = _Divider(modifier = modifier, color = color ?: MaterialTheme.colors.onSurface.copy(alpha = DividerAlpha), thickness = thickness, startIndent = startIndent)

private const val DividerAlpha = 0.12f