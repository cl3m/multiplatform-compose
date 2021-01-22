package com.rouge41.kmm.compose

import cocoapods.YogaKit.*
import platform.Foundation.NSLog
import platform.UIKit.*


actual enum class TextOverflow {
    Clip,
    Ellipsis,
}

@Composable
actual fun Text(
    text: String,
    modifier: Modifier,
    color: Color,
    fontSize: TextUnit,
    fontStyle: FontStyle?,
    fontWeight: FontWeight?,
    fontFamily: FontFamily?,
    letterSpacing: TextUnit,
    textDecoration: TextDecoration?,
    textAlign: TextAlign?,
    lineHeight: TextUnit,
    overflow: TextOverflow,
    softWrap: Boolean,
    maxLines: Int,
    /*onTextLayout: (TextLayoutResult) -> Unit,*/
    style: TextStyle?
) {
    val controller = getCurrentController()
    val view = getCurrentView()
    val color = if (color != Color.Unspecified) color else style?.color
    if (controller is ComposeAlertController) {
        controller.text = text
    } else if (view is UIButton) {
        view.setTitle(text, 0)
        color?.let { view.setTitleColor(it.toUIColor(), 0) }
        view.titleLabel?.font = (style ?: TextStyle()).toUIFont(overrideFontSize = if (fontSize != TextUnit.Unspecified) fontSize else null,
            overrideFontStyle = fontStyle, overrideFontWeight = fontWeight, overrideFontFamily = fontFamily)
        modifier.setup(view)
    } else {
        val label = UILabel()
        label.numberOfLines = 0
        label.text = text
        label.sizeToFit()
        color?.toUIColor()?.let { label.textColor = it }
        label.font = (style ?: TextStyle()).toUIFont(overrideFontSize = if (fontSize != TextUnit.Unspecified) fontSize else null,
            overrideFontStyle = fontStyle, overrideFontWeight = fontWeight, overrideFontFamily = fontFamily)
        modifier.setup(label)
        view.addSubview(label)
    }
}