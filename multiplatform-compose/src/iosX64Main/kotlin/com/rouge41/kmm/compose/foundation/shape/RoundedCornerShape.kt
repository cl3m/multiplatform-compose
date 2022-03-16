package com.rouge41.kmm.compose.foundation.shape

import com.rouge41.kmm.compose.ui.graphics.Shape
import com.rouge41.kmm.compose.ui.unit.Dp

actual abstract class CornerBasedShape(
        actual val topStart: CornerSize,
        actual val topEnd: CornerSize,
        actual val bottomEnd: CornerSize,
        actual val bottomStart: CornerSize
): Shape {
    actual abstract fun copy(
            topStart: CornerSize,
            topEnd: CornerSize,
            bottomEnd: CornerSize,
            bottomStart: CornerSize
    ): CornerBasedShape
}

actual interface CornerSize

actual class RoundedCornerShape(
        topStart: CornerSize,
        topEnd: CornerSize,
        bottomEnd: CornerSize,
        bottomStart: CornerSize
) : CornerBasedShape(topStart, topEnd, bottomEnd, bottomStart) {
    override fun copy(
            topStart: CornerSize,
            topEnd: CornerSize,
            bottomEnd: CornerSize,
            bottomStart: CornerSize
    ): CornerBasedShape = RoundedCornerShape(topStart, topEnd, bottomEnd, bottomStart)
}

actual fun RoundedCornerShape(size: Dp): CornerBasedShape = com.rouge41.kmm.compose.foundation.shape.RoundedCornerShape(size, size, size, size)