package com.rouge41.kmm.compose.material

import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ui.Modifier
import com.rouge41.kmm.compose.ui.graphics.Color
import androidx.compose.material.Text as _Text

@Composable
@Suppress("ACTUAL_FUNCTION_WITH_DEFAULT_ARGUMENTS")
actual fun Text(
        text: String,
        modifier: Modifier = Modifier,
        color: Color = Color.Unspecified,
) = _Text(text = text, modifier = modifier, color = color)