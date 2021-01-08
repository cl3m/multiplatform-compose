package com.rouge41.kmm.compose

actual inline class Dp(val value: Float)

actual inline val Int.dp: Dp get() = Dp(value = this.toFloat())

fun Dp.toCGFloat() = value.toDouble()
