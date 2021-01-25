package com.rouge41.kmm.compose.material

import com.rouge41.kmm.compose.foundation.shape.CornerBasedShape
import com.rouge41.kmm.compose.foundation.shape.RoundedCornerShape
import com.rouge41.kmm.compose.ui.unit.dp

actual class Shapes {
    actual val small: CornerBasedShape = RoundedCornerShape(4.dp)
    actual val medium: CornerBasedShape = RoundedCornerShape(4.dp)
    actual val large: CornerBasedShape = RoundedCornerShape(0.dp)
}