package com.rouge41.kmm.compose.ui

import cocoapods.YogaKit.*
import com.rouge41.kmm.compose.foundation.layout.PaddingValues
import com.rouge41.kmm.compose.foundation.shape.CornerBasedShape
import com.rouge41.kmm.compose.ios.UIComposeView
import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ui.graphics.Color
import com.rouge41.kmm.compose.ui.graphics.Shape
import com.rouge41.kmm.compose.ui.unit.Dp
import com.rouge41.kmm.compose.ui.unit.toCGFloat
import platform.CoreGraphics.CGFloat
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
        data class padding(val values: PaddingValues) : Layout()
        data class width(val dp: Dp) : Layout()
        data class height(val dp: Dp) : Layout()
        data class clip(val dp: Dp) : Layout()
        data class aspectRatio(val ratio: CGFloat) : Layout()
        data class weight(val weight: CGFloat, val fill: Boolean) : Layout()
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
                    /*is Layout.padding -> {
                        layout?.paddingStart = YGPointValue(change.values.start.toCGFloat())
                        layout?.paddingTop = YGPointValue(change.values.top.toCGFloat())
                        layout?.paddingEnd = YGPointValue(change.values.end.toCGFloat())
                        layout?.paddingBottom = YGPointValue(change.values.bottom.toCGFloat())
                    }*/
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
                    is Layout.clip -> {
                        view.clipsToBounds = true
                        view.layer.cornerRadius = change.dp.toCGFloat()
                    }
                    is Layout.aspectRatio -> layout?.aspectRatio = change.ratio
                    is Layout.weight -> {
                        layout?.flexGrow = change.weight
                        layout?.width = YGPointValue(0.0)
                        layout?.height = YGPointValue(0.0)
                    }
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
    modifier.changes.add(iosModifier.Layout.padding(PaddingValues(dp)))
    return modifier
}

/*actual fun Modifier.padding(start: Dp, top: Dp, end: Dp, bottom: Dp): Modifier {
    val modifier = if (this is iosModifier) { this } else { iosModifier() }
    modifier.changes.add(iosModifier.Layout.padding(PaddingValues(start, top, end, bottom)))
    return modifier
}*/

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

actual fun Modifier.size(dp: Dp): Modifier = height(dp).width(dp)

@Composable
actual fun Modifier.clickable(onClick: () -> Unit): Modifier {
    val modifier = if (this is iosModifier) { this } else { iosModifier() }
    modifier.onClick = onClick
    return modifier
}

actual fun Modifier.clip(shape: Shape): Modifier {
    val modifier = if (this is iosModifier) { this } else { iosModifier() }
    /*if (shape is CornerBasedShape) {
        modifier.changes.add(iosModifier.Layout.clip(shape.topLeft as Dp))
    }*/
    return modifier
}
actual fun Modifier.aspectRatio(ratio: Float, matchHeightConstraintsFirst: Boolean): Modifier {
    val modifier = if (this is iosModifier) { this } else { iosModifier() }
    modifier.changes.add(iosModifier.Layout.aspectRatio(ratio.toDouble()))
    return modifier
}