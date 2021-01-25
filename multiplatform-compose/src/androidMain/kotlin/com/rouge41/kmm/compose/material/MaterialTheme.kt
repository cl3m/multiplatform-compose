package com.rouge41.kmm.compose.material

import com.rouge41.kmm.compose.runtime.Composable
import androidx.compose.material.MaterialTheme as _MaterialTheme

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

