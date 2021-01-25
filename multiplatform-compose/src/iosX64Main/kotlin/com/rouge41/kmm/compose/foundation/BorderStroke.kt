package com.rouge41.kmm.compose.foundation

import com.rouge41.kmm.compose.ui.graphics.Brush
import com.rouge41.kmm.compose.ui.unit.Dp
import com.rouge41.kmm.compose.ui.graphics.Color
import com.rouge41.kmm.compose.ui.graphics.SolidColor

actual data class BorderStroke(actual val width: Dp, actual val brush: Brush)

actual fun BorderStroke(width: Dp, color: Color): BorderStroke = BorderStroke(width, SolidColor(color))