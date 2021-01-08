package com.rouge41.kmm.compose

expect class FontWeight
expect sealed class FontFamily
expect inline class TextUnit(val packedValue: Long)
expect class TextStyle
expect enum class FontStyle

expect val Int.sp: TextUnit
