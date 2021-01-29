package com.rouge41.kmm.compose.foundation.layout

import cocoapods.YogaKit.*
import com.rouge41.kmm.compose.ios.UIComposeView
import com.rouge41.kmm.compose.ios.addSubview
import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ui.*
import com.rouge41.kmm.compose.ui.unit.toCGFloat
import platform.UIKit.UIView
import platform.UIKit.subviews

actual interface RowScope {
    actual fun Modifier.weight(
        weight: Float,
        fill: Boolean
    ): Modifier
}

class iosRowScope : RowScope {
    override fun Modifier.weight(weight: Float, fill: Boolean): Modifier {
        val modifier = if (this is iosModifier) { this } else { iosModifier() }
        modifier.changes.add(iosModifier.Layout.weight(weight.toDouble(), fill))
        return modifier
    }
}

@Composable
actual fun Row(
        modifier: Modifier,
        horizontalArrangement: ArrangementHorizontal,
        verticalAlignment: AlignmentVertical,
        content: @Composable RowScope.() -> Unit
) {
    val view = UIComposeView.createOrReuse("${content::class}")
    modifier.setup(view)
    view.configureLayoutWithBlock { layout ->
        layout?.flexDirection = YGFlexDirection.YGFlexDirectionRow
        when (horizontalArrangement) {
            iosArrangementHorizontal.Start -> layout?.justifyContent = YGJustify.YGJustifyFlexStart
            iosArrangementHorizontal.End -> layout?.justifyContent = YGJustify.YGJustifyFlexEnd
            iosArrangement.Center -> layout?.justifyContent = YGJustify.YGJustifyCenter
            iosArrangement.SpaceEvenly -> layout?.justifyContent = YGJustify.YGJustifySpaceEvenly
            iosArrangement.SpaceBetween -> layout?.justifyContent = YGJustify.YGJustifySpaceBetween
            iosArrangement.SpaceAround -> layout?.justifyContent = YGJustify.YGJustifySpaceAround
        }
        when (verticalAlignment) {
            iosAlignmentVertical.Top -> layout?.alignItems = YGAlign.YGAlignFlexStart
            iosAlignmentVertical.CenterVertically -> layout?.alignItems = YGAlign.YGAlignCenter
            iosAlignmentVertical.Bottom -> layout?.alignItems = YGAlign.YGAlignFlexEnd
        }
    }
    addSubview(view) { content.invoke(iosRowScope()) }
    if (horizontalArrangement is iosArrangement.spacedBy) {
        for ((index, subview) in view.subviews.withIndex()) {
            if (subview is UIView && index > 0) {
                subview.configureLayoutWithBlock { layout ->
                    layout?.marginLeft = YGPointValue(horizontalArrangement.space.toCGFloat())
                }
            }
        }
    }
}