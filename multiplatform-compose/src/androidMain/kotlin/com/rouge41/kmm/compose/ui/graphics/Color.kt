package com.rouge41.kmm.compose.ui.graphics

import androidx.compose.ui.graphics.Color as _Color

actual typealias Color = androidx.compose.ui.graphics.Color

actual fun Color(color: Long): Color = _Color(color)

actual fun Color.copy(
    alpha: Float?,
    red: Float?,
    green: Float?,
    blue: Float?
): Color =  this.copy(alpha = alpha ?: this.alpha, red = red ?: this.red, green = green ?: this.green, blue = blue ?: this.blue)