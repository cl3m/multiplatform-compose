package com.rouge41.kmm.compose.ui.unit

actual inline class TextUnit(val packedValue: Long) {
    actual companion object {
        actual val Unspecified = TextUnit(Long.MAX_VALUE)
    }
}

actual inline val Int.sp: TextUnit get() = TextUnit(packedValue = this.toLong())
actual inline val Double.sp: TextUnit get() = TextUnit(packedValue = this.toLong())