package com.rouge41.kmm.compose.ios

import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ui.graphics.Color
import platform.UIKit.*

@Composable
actual fun HumanAppearance(tintColor: Color, backgroundColor: Color?, content: @Composable () -> Unit) {
    getHostingView().window?.setTintColor(tintColor.toUIColor())
    getHostingView().setTintColor(tintColor.toUIColor())
    getHostingView().backgroundColor = backgroundColor?.toUIColor() ?: systemBackgroundColor()
    //UILabel.appearance().setFont(style.toUIFont())
    content()
}
