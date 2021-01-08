package com.rouge41.kmm.compose

import androidx.compose.ui.unit.Dp as _Dp

actual typealias Dp = androidx.compose.ui.unit.Dp

actual inline val Int.dp: Dp get() = _Dp(value = this.toFloat())
