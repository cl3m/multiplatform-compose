package com.rouge41.kmm.compose.foundation.shape

import com.rouge41.kmm.compose.ui.graphics.Shape
import com.rouge41.kmm.compose.ui.unit.Dp

expect abstract class CornerBasedShape: Shape {
    val topStart: CornerSize
    val topEnd: CornerSize
    val bottomEnd: CornerSize
    val bottomStart: CornerSize

    abstract fun copy(
            topStart: CornerSize = this.topStart,
            topEnd: CornerSize = this.topEnd,
            bottomEnd: CornerSize = this.bottomEnd,
            bottomStart: CornerSize = this.bottomStart
    ): CornerBasedShape
}
expect interface CornerSize
expect class RoundedCornerShape: CornerBasedShape

expect fun RoundedCornerShape(size: Dp) : CornerBasedShape