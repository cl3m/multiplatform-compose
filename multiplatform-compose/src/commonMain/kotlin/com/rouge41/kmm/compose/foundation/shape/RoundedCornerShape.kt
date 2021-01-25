package com.rouge41.kmm.compose.foundation.shape

import com.rouge41.kmm.compose.ui.graphics.Shape
import com.rouge41.kmm.compose.ui.unit.Dp

expect abstract class CornerBasedShape: Shape {
    val topLeft: CornerSize
    val topRight: CornerSize
    val bottomRight: CornerSize
    val bottomLeft: CornerSize

    abstract fun copy(
            topLeft: CornerSize = this.topLeft,
            topRight: CornerSize = this.topRight,
            bottomRight: CornerSize = this.bottomRight,
            bottomLeft: CornerSize = this.bottomLeft
    ): CornerBasedShape
}
expect interface CornerSize
expect class RoundedCornerShape: CornerBasedShape

expect fun RoundedCornerShape(size: Dp) : CornerBasedShape