package com.rouge41.kmm.compose

import cocoapods.YogaKit.*
import kotlinx.cinterop.ExportObjCClass
import kotlinx.cinterop.ObjCAction
import kotlinx.cinterop.cValue
import kotlinx.cinterop.useContents
import platform.CoreGraphics.CGFLOAT_MAX
import platform.CoreGraphics.CGFloat
import platform.CoreGraphics.CGRectZero
import platform.CoreGraphics.CGSizeMake
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
        val container = UIComposeView(text)
        val label = UILabel()
        label.numberOfLines = 0
        label.text = text
        color?.toUIColor()?.let { label.textColor = it }
        label.font = (style ?: TextStyle()).toUIFont(overrideFontSize = if (fontSize != TextUnit.Unspecified) fontSize else null,
            overrideFontStyle = fontStyle, overrideFontWeight = fontWeight, overrideFontFamily = fontFamily)
        //Set cell margin before custom
        val cell = getCurrentView().superview
        if (cell is UITableViewCell) {
            container.configureLayoutWithBlock { layout ->
                layout?.paddingTop = YGPointValue( cell.layoutMargins.useContents { top } )
                layout?.paddingLeft = YGPointValue( cell.layoutMargins.useContents { left } )
                layout?.paddingBottom = YGPointValue( cell.layoutMargins.useContents { bottom } )
                layout?.paddingRight = YGPointValue( cell.layoutMargins.useContents { right } )
            }
        }
        modifier.setup(container)
        modifier.setup(label)
        container.addSubview(label)
        view.addSubview(container)
    }
}

@ExportObjCClass
class ComposeLabel(val contentIdentifier: String) : UILabel(frame = cValue { CGRectZero }) {
    var isDirty: Boolean = false

    init {
        if (DEBUG_COMPOSE) NSLog("🔴 [init ComposeLabel]")
    }

    companion object {
        fun createOrReuse(onClick: () -> Unit): ComposeLabel {
            val contentIdentifier = "${onClick::class}"
            for (view in getCurrentView().subviews) {
                if (view is ComposeLabel && view.isDirty && view.contentIdentifier == contentIdentifier) {
                    if (DEBUG_COMPOSE) NSLog("🟢 [reuse ComposeLabel] ${view.contentIdentifier}")
                    view.isDirty = false
                    return view
                }
            }
            return ComposeLabel(contentIdentifier)
        }
    }
}