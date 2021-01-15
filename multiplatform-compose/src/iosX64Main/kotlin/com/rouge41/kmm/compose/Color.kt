package com.rouge41.kmm.compose

import platform.CoreGraphics.CGFloat
import platform.UIKit.UIColor

actual inline class Color(val value: ULong) {
    actual companion object {
        actual val Black = Color(4278190080u)
        actual val DarkGray = Color(4282664004u)
        actual val Gray = Color(4287137928u)
        actual val LightGray = Color(4291611852u)
        actual val White = Color(4294967295u)
        actual val Red = Color(4294901760u)
        actual val Green = Color(4278255360u)
        actual val Blue = Color(4278190335u)
        actual val Yellow = Color(4294967040u)
        actual val Cyan = Color(4278255615u)
        actual val Magenta = Color(4294902015u)
        actual val Transparent = Color(0u)
        actual val Unspecified = Color(ULong.MAX_VALUE)
    }
}

fun Color.toUIColor(): UIColor? {
    return if (value == ULong.MAX_VALUE) {
        null
    } else {
        val alpha: CGFloat = (value and 4278190080u shr 24).toDouble() / 255.0
        val red: CGFloat = (value and 16711680u shr 16).toDouble() / 255.0
        val green: CGFloat = (value and 65280u shr 8).toDouble() / 255.0
        val blue: CGFloat = (value and 255u).toDouble() / 255.0
        UIColor(red = red, green = green, blue = blue, alpha = alpha)
    }
}

actual fun Color(color: Long): Color {
    return Color(value = color.toULong())
}