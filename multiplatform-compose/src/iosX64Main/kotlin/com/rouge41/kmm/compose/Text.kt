package com.rouge41.kmm.compose

import cocoapods.YogaKit.*
import platform.UIKit.*

@Composable
actual fun Text(text: String, modifier: Modifier, style: TextStyle) {
    val view = getCurrentView()
    if (view is UIButton) {
        view.setTitle(text, 0)
        style.color?.let { view.setTitleColor(it.toUIColor(), 0) }
        modifier.setup(view)
    } else {
        val label = UILabel()
        label.numberOfLines = 0
        label.text = text
        label.sizeToFit()
        modifier.setup(label)
        view.addSubview(label)
        style.color?.toUIColor()?.let { label.textColor = it }
        label.font = style.toUIFont()
    }
}

@Composable
actual fun Text(text: String, style: TextStyle) {
    Text(text = text, modifier = Modifier, style = style)
}

@Composable
actual fun Text(text: String, modifier: Modifier) {
    Text(text = text, modifier = modifier, style = TextStyle())
}

@Composable
actual fun Text(text: String) {
    Text(text = text, modifier = Modifier, style = TextStyle())
}
