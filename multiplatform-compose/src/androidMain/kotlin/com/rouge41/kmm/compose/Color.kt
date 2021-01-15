package com.rouge41.kmm.compose

import androidx.compose.ui.graphics.Color as _Color

actual typealias Color = androidx.compose.ui.graphics.Color

actual fun Color(color: Long): Color = _Color(color)