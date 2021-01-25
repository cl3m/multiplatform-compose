package com.rouge41.kmm.compose.ui.unit

import com.rouge41.kmm.compose.foundation.shape.CornerSize

actual inline class Dp(val value: Float) : CornerSize

actual inline val Int.dp: Dp get() = Dp(value = this.toFloat())

fun Dp.toCGFloat() = value.toDouble()
