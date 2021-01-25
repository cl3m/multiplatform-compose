package com.rouge41.kmm.compose.ios

import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ui.graphics.Color
import com.rouge41.kmm.compose.ui.text.TextStyle
import platform.UIKit.*

@Composable
actual fun HumanAppearance(tintColor: Color, backgroundColor: Color?, style: TextStyle, content: @Composable () -> Unit) {
    getHostingView().window?.setTintColor(tintColor.toUIColor())
    getHostingView().setTintColor(tintColor.toUIColor())
    getHostingView().backgroundColor = backgroundColor?.toUIColor() ?: systemBackgroundColor()
    UILabel.appearance().setFont(style.toUIFont())
    content()
}
