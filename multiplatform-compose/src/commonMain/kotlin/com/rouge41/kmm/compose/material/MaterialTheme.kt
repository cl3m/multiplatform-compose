package com.rouge41.kmm.compose.material

import com.rouge41.kmm.compose.foundation.shape.CornerBasedShape
import com.rouge41.kmm.compose.material.Colors
import com.rouge41.kmm.compose.material.Shapes
import com.rouge41.kmm.compose.material.Typography
import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ui.unit.Dp

expect object MaterialTheme {
    val colors: Colors
    val typography: Typography
    val shapes: Shapes
}

@Composable
expect fun MaterialTheme(
        colors: Colors? = null,
        typography: Typography? = null,
        shapes: Shapes? = null,
        content: @Composable () -> Unit
)

