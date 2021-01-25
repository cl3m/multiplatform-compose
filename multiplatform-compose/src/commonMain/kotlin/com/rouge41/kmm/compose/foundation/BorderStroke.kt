package com.rouge41.kmm.compose.foundation

import com.rouge41.kmm.compose.ui.graphics.Brush
import com.rouge41.kmm.compose.ui.unit.Dp
import com.rouge41.kmm.compose.ui.graphics.Color

expect class BorderStroke {
    val width: Dp
    val brush: Brush
}

expect fun BorderStroke(width: Dp, color: Color): BorderStroke