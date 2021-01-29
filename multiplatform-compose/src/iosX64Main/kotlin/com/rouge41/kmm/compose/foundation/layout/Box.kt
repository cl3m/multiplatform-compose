package com.rouge41.kmm.compose.foundation.layout

import cocoapods.YogaKit.*
import com.rouge41.kmm.compose.ios.UIComposeView
import com.rouge41.kmm.compose.ios.addSubview
import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ui.AlignmentVerticalAndHorizontal
import com.rouge41.kmm.compose.ui.Modifier
import com.rouge41.kmm.compose.ui.iosAlignment
import com.rouge41.kmm.compose.ui.iosAlignmentVertical

actual interface BoxScope
class iosBoxScope : BoxScope

@Composable
actual fun Box(
    modifier: Modifier,
    contentAlignment: AlignmentVerticalAndHorizontal,
    content: @Composable BoxScope.() -> Unit
) {
    val view = UIComposeView.createOrReuse("${content::class}")
    modifier.setup(view)
    view.configureLayoutWithBlock { layout ->
        when (contentAlignment) {
            iosAlignment.TopStart -> {
                layout?.alignItems = YGAlign.YGAlignFlexStart
                layout?.justifyContent = YGJustify.YGJustifyFlexStart
            }
            iosAlignment.TopCenter -> {
                layout?.alignItems = YGAlign.YGAlignFlexStart
                layout?.justifyContent = YGJustify.YGJustifyCenter
            }
            iosAlignment.TopEnd -> {
                layout?.alignItems = YGAlign.YGAlignFlexStart
                layout?.justifyContent = YGJustify.YGJustifyFlexEnd
            }
            iosAlignment.CenterStart -> {
                layout?.alignItems = YGAlign.YGAlignCenter
                layout?.justifyContent = YGJustify.YGJustifyFlexStart
            }
            iosAlignment.Center -> {
                layout?.alignItems = YGAlign.YGAlignCenter
                layout?.justifyContent = YGJustify.YGJustifyCenter
            }
            iosAlignment.CenterEnd -> {
                layout?.alignItems = YGAlign.YGAlignCenter
                layout?.justifyContent = YGJustify.YGJustifyFlexEnd
            }
            iosAlignment.BottomStart -> {
                layout?.alignItems = YGAlign.YGAlignFlexEnd
                layout?.justifyContent = YGJustify.YGJustifyFlexStart
            }
            iosAlignment.BottomCenter -> {
                layout?.alignItems = YGAlign.YGAlignFlexEnd
                layout?.justifyContent = YGJustify.YGJustifyCenter
            }
            iosAlignment.BottomEnd -> {
                layout?.alignItems = YGAlign.YGAlignFlexEnd
                layout?.justifyContent = YGJustify.YGJustifyFlexEnd
            }
        }
    }
    addSubview(view) { content.invoke(iosBoxScope()) }
}