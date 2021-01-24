package com.rouge41.kmm.compose

import platform.CoreGraphics.CGFloat
import platform.Foundation.NSLog
import platform.UIKit.UIColor
import platform.UIKit.tintColor
import platform.UIKit.window

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
        val Tint = Color(ULong.MAX_VALUE - 1u)
    }

    fun copy(
        alpha: CGFloat = this.alpha,
        red: CGFloat = this.red,
        green: CGFloat = this.green,
        blue: CGFloat = this.blue
    ): Color = Color(
        red = red,
        green = green,
        blue = blue,
        alpha = alpha
    )

    internal fun Color(red: CGFloat, green: CGFloat, blue: CGFloat, alpha: CGFloat): Color {
        val argb = (
                ((alpha * 255.0).toInt() shl 24) or
                        ((red * 255.0).toInt() shl 16) or
                        ((green * 255.0).toInt() shl 8) or
                        (blue * 255.0).toInt()
                )
        return Color(value = argb.toULong())
    }

    internal val alpha: CGFloat
        get() = (value and 4278190080u shr 24).toDouble() / 255.0
    internal val red: CGFloat
        get() = (value and 16711680u shr 16).toDouble() / 255.0
    internal val green: CGFloat
        get() = (value and 65280u shr 8).toDouble() / 255.0
    internal val blue: CGFloat
        get() = (value and 255u).toDouble() / 255.0

    fun toUIColor(): UIColor? {
        return if (value == Unspecified.value) {
            null
        } else return if (value == Tint.value) {
            getHostingView().tintColor
        } else {
            UIColor(red = red, green = green, blue = blue, alpha = alpha)
        }
    }
}

actual fun Color(color: Long): Color {
    return Color(value = color.toULong())
}

actual fun Color.copy(
    alpha: Float?,
    red: Float?,
    green: Float?,
    blue: Float?
): Color = Color(red?.toDouble() ?: this.red, green?.toDouble() ?: this.green, blue?.toDouble() ?: this.blue, alpha?.toDouble() ?: this.alpha)