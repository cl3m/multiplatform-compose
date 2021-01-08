package com.rouge41.kmm.compose

import cocoapods.YogaKit.*
import kotlinx.cinterop.CValue
import kotlinx.cinterop.cValue
import kotlinx.cinterop.useContents
import platform.CoreGraphics.*
import platform.UIKit.*

class HostingView() : UIView(frame = cValue { CGRectZero }) {
    init {
        this.backgroundColor = UIColor.systemBackgroundColor
    }
    fun setContent(content: @Composable () -> Unit) {
        this.configureLayoutWithBlock { layout ->
            layout?.isEnabled = true
            layout?.width = YGPercentValue(100.0)
            layout?.height = YGPercentValue(100.0)
            layout?.flexDirection = YGFlexDirection.YGFlexDirectionColumn
            layout?.justifyContent = YGJustify.YGJustifyFlexStart
            layout?.alignItems = YGAlign.YGAlignFlexStart
        }
        content()
    }
}
