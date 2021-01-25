package com.rouge41.kmm.compose.foundation.shape

import com.rouge41.kmm.compose.ui.unit.Dp
import androidx.compose.foundation.shape.RoundedCornerShape as _RoundedCornerShape

actual typealias CornerBasedShape = androidx.compose.foundation.shape.CornerBasedShape
actual typealias RoundedCornerShape = androidx.compose.foundation.shape.RoundedCornerShape
actual typealias CornerSize = androidx.compose.foundation.shape.CornerSize

actual fun RoundedCornerShape(size: Dp): CornerBasedShape = _RoundedCornerShape(size)