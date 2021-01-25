package com.rouge41.kmm.compose.ui.unit

expect inline class TextUnit(val packedValue: Long) {
    companion object {
        val Unspecified: TextUnit
    }
}

expect val Int.sp: TextUnit
expect val Double.sp: TextUnit