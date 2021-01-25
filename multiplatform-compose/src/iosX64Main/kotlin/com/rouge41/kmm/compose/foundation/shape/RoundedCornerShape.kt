package com.rouge41.kmm.compose.foundation.shape

import com.rouge41.kmm.compose.ui.graphics.Shape
import com.rouge41.kmm.compose.ui.unit.Dp

actual abstract class CornerBasedShape(
        actual val topLeft: CornerSize,
        actual val topRight: CornerSize,
        actual val bottomRight: CornerSize,
        actual val bottomLeft: CornerSize
): Shape {
    actual abstract fun copy(
            topLeft: CornerSize,
            topRight: CornerSize,
            bottomRight: CornerSize,
            bottomLeft: CornerSize
    ): CornerBasedShape
}

actual interface CornerSize

actual class RoundedCornerShape(
        topLeft: CornerSize,
        topRight: CornerSize,
        bottomRight: CornerSize,
        bottomLeft: CornerSize
) : CornerBasedShape(topLeft, topRight, bottomRight, bottomLeft) {
    override fun copy(
            topLeft: CornerSize,
            topRight: CornerSize,
            bottomRight: CornerSize,
            bottomLeft: CornerSize
    ): CornerBasedShape = RoundedCornerShape(topLeft, topRight, bottomRight, bottomLeft)
}

actual fun RoundedCornerShape(size: Dp): CornerBasedShape = com.rouge41.kmm.compose.foundation.shape.RoundedCornerShape(size, size, size, size)