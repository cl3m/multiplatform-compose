package com.rouge41.kmm.compose.foundation

import com.rouge41.kmm.compose.ui.unit.Dp
import com.rouge41.kmm.compose.ui.graphics.Color
import androidx.compose.foundation.BorderStroke as _BorderStroke

actual typealias BorderStroke = androidx.compose.foundation.BorderStroke

actual fun BorderStroke(width: Dp, color: Color) = _BorderStroke(width = width, color = color)