package com.rouge41.kmm.compose.material

import androidx.compose.material.MaterialTheme
import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ui.Modifier
import com.rouge41.kmm.compose.ui.graphics.Color
import com.rouge41.kmm.compose.ui.unit.Dp
import com.rouge41.kmm.compose.ui.unit.dp
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