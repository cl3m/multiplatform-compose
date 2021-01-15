package com.rouge41.kmm.compose

import cocoapods.YogaKit.*
import platform.UIKit.*

actual interface ColumnScope
class iosColumnScope : ColumnScope

@Composable
actual fun Column(
    modifier: Modifier,
    verticalArrangement: ArrangementVertical,
    horizontalAlignment: AlignmentHorizontal,
    content: @Composable ColumnScope.() -> Unit
) {
    val view = UIComposeView.createOrReuse("${content::class}")
    modifier.setup(view)
    view.configureLayoutWithBlock { layout ->
        layout?.flexDirection = YGFlexDirection.YGFlexDirectionColumn
        when (verticalArrangement) {
            iosArrangementVertical.Top -> layout?.justifyContent = YGJustify.YGJustifyFlexStart
            iosArrangementVertical.Bottom -> layout?.justifyContent = YGJustify.YGJustifyFlexEnd
            iosArrangement.Center -> layout?.justifyContent = YGJustify.YGJustifyCenter
            iosArrangement.SpaceEvenly -> layout?.justifyContent = YGJustify.YGJustifySpaceEvenly
            iosArrangement.SpaceBetween -> layout?.justifyContent = YGJustify.YGJustifySpaceBetween
            iosArrangement.SpaceAround -> layout?.justifyContent = YGJustify.YGJustifySpaceAround
        }
        when (horizontalAlignment) {
            iosAlignmentHorizontal.Start -> layout?.alignItems = YGAlign.YGAlignFlexStart
            iosAlignmentHorizontal.CenterHorizontally -> layout?.alignItems = YGAlign.YGAlignCenter
            iosAlignmentHorizontal.End -> layout?.alignItems = YGAlign.YGAlignFlexEnd
        }
    }
    addSubview(view) { content.invoke(iosColumnScope()) }
}