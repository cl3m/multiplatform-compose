package com.rouge41.kmm.compose

import cocoapods.YogaKit.*
import platform.Foundation.NSLog
import platform.Foundation.NSSelectorFromString
import platform.UIKit.*

actual interface Modifier {
    actual companion object : Modifier {
    }

    fun setup(view: UIView) {
        view.configureLayoutWithBlock { layout ->
            layout?.isEnabled = true
        }
    }
}

class iosModifier : Modifier {
    var changes = mutableListOf<Layout>()
    var backgroundColor: Color? = null
    var onClick: (() -> Unit)? = null


    sealed class Layout {
        data class margin(val dp: Dp) : Layout()
        data class padding(val dp: Dp) : Layout()
        data class width(val dp: Dp) : Layout()
        data class height(val dp: Dp) : Layout()
        object fillMaxWidth : Layout()
        object fillMaxHeight : Layout()
    }

    override fun setup(view: UIView) {
        super.setup(view)
        backgroundColor?.let {
            view.backgroundColor = it.toUIColor()
        }
        onClick?.let {
            if (view is UIComposeView) {
                val tapController = UITapGestureRecognizer()
                tapController.addTarget(
                    target = view,
                    action = NSSelectorFromString("tap"),
                )
                view.userInteractionEnabled = true
                view.onClick = it
                view.addGestureRecognizer(tapController)
            }
        }
        view.configureLayoutWithBlock { layout ->
            for (change in this.changes) {
                when (change) {
                    is Layout.padding -> layout?.padding = YGPointValue(change.dp.toCGFloat())
                    is Layout.margin -> layout?.margin = YGPointValue(change.dp.toCGFloat())
                    is Layout.fillMaxWidth -> {
                        layout?.maxWidth = YGPercentValue(100.0)
                        layout?.width = YGPercentValue(100.0)
                    }
                    is Layout.fillMaxHeight -> {
                        layout?.maxHeight = YGPercentValue(100.0)
                        layout?.height = YGPercentValue(100.0)
                    }
                    is Layout.width -> layout?.width = YGPointValue(change.dp.toCGFloat())
                    is Layout.height -> layout?.height = YGPointValue(change.dp.toCGFloat())
                }
            }
        }
    }
}

actual fun Modifier.fillMaxSize(): Modifier {
    val modifier = if (this is iosModifier) { this } else { iosModifier() }
    modifier.changes.add(iosModifier.Layout.fillMaxWidth)
    modifier.changes.add(iosModifier.Layout.fillMaxHeight)
    return modifier
}

actual fun Modifier.fillMaxWidth(): Modifier {
    val modifier = if (this is iosModifier) { this } else { iosModifier() }
    modifier.changes.add(iosModifier.Layout.fillMaxWidth)
    return modifier
}

actual fun Modifier.fillMaxHeight(): Modifier {
    val modifier = if (this is iosModifier) { this } else { iosModifier() }
    modifier.changes.add(iosModifier.Layout.fillMaxHeight)
    return modifier
}

actual fun Modifier.padding(dp: Dp): Modifier {
    val modifier = if (this is iosModifier) { this } else { iosModifier() }
    modifier.changes.add(iosModifier.Layout.padding(dp))
    return modifier
}

fun Modifier.margin(dp: Dp): Modifier {
    val modifier = if (this is iosModifier) { this } else { iosModifier() }
    modifier.changes.add(iosModifier.Layout.margin(dp))
    return modifier
}

actual fun Modifier.background(color: Color): Modifier {
    val modifier = if (this is iosModifier) { this } else { iosModifier() }
    modifier.backgroundColor = color
    return modifier
}

actual fun Modifier.width(dp: Dp): Modifier {
    val modifier = if (this is iosModifier) { this } else { iosModifier() }
    modifier.changes.add(iosModifier.Layout.width(dp))
    return modifier
}

actual fun Modifier.height(dp: Dp): Modifier {
    val modifier = if (this is iosModifier) { this } else { iosModifier() }
    modifier.changes.add(iosModifier.Layout.height(dp))
    return modifier
}

actual fun Modifier.preferredWidth(dp: Dp): Modifier = width(dp)
actual fun Modifier.preferredHeight(dp: Dp): Modifier = height(dp)
actual fun Modifier.preferredSize(dp: Dp): Modifier = height(dp).width(dp)

@Composable
actual fun Modifier.clickable(onClick: () -> Unit): Modifier {
    val modifier = if (this is iosModifier) { this } else { iosModifier() }
    modifier.onClick = onClick
    return modifier
}