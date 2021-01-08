package com.rouge41.kmm.compose

import platform.UIKit.*

@Composable
actual fun HumanAppearance(tintColor: Color, backgroundColor: Color?, style: TextStyle, content: @Composable () -> Unit) {
    getHostingView().window?.setTintColor(tintColor.toUIColor())
    getHostingView().backgroundColor = backgroundColor?.toUIColor() ?: UIColor.systemBackgroundColor
    UILabel.appearance().setFont(style.toUIFont())
    content()
}
