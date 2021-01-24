package com.rouge41.kmm.compose

expect inline class Color(val value: ULong) {
    companion object {
        val Black : Color
        val DarkGray : Color
        val Gray : Color
        val LightGray : Color
        val White : Color
        val Red : Color
        val Green : Color
        val Blue : Color
        val Yellow : Color
        val Cyan : Color
        val Magenta : Color
        val Transparent : Color
        val Unspecified: Color
    }
}

expect fun Color(color: Long): Color

expect fun Color.copy(
    alpha: Float? = null,
    red: Float? = null,
    green: Float? = null,
    blue: Float? = null,
): Color