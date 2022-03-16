package com.rouge41.kmm.compose.material

import com.rouge41.kmm.compose.runtime.Composable

expect object MaterialTheme {
    val colors: Colors
    val shapes: Shapes
}

@Composable
expect fun MaterialTheme(
        colors: Colors? = null,
        shapes: Shapes? = null,
        content: @Composable () -> Unit
)

