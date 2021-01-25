package com.rouge41.kmm.compose.material

import cocoapods.YogaKit.*
import com.rouge41.kmm.compose.ios.DEBUG_COMPOSE
import com.rouge41.kmm.compose.ios.UIComposeView
import com.rouge41.kmm.compose.ios.getCurrentController
import com.rouge41.kmm.compose.ios.getCurrentView
import com.rouge41.kmm.compose.navigation.BarButtonItemScope
import com.rouge41.kmm.compose.navigation.UIComposeViewController
import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ui.text.style.TextOverflow
import com.rouge41.kmm.compose.ui.Modifier
import com.rouge41.kmm.compose.ui.graphics.Color
import com.rouge41.kmm.compose.ui.margin
import com.rouge41.kmm.compose.ui.padding
import com.rouge41.kmm.compose.ui.text.TextAlign
import com.rouge41.kmm.compose.ui.text.TextDecoration
import com.rouge41.kmm.compose.ui.text.TextStyle
import com.rouge41.kmm.compose.ui.text.font.FontFamily
import com.rouge41.kmm.compose.ui.text.font.FontStyle
import com.rouge41.kmm.compose.ui.text.font.FontWeight
import com.rouge41.kmm.compose.ui.unit.TextUnit
import com.rouge41.kmm.compose.ui.unit.dp
import kotlinx.cinterop.ExportObjCClass
import kotlinx.cinterop.cValue
import kotlinx.cinterop.useContents
import platform.CoreGraphics.CGRectZero
import platform.Foundation.NSLog
import platform.UIKit.*


@Composable
actual fun Text(
        text: String,
        modifier: Modifier,
        color: com.rouge41.kmm.compose.ui.graphics.Color,
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
    } else if (controller is UIComposeViewController && controller.barButtonItemScope != BarButtonItemScope.NONE) {
        when (controller.barButtonItemScope) {
            BarButtonItemScope.LEADING -> controller.navigationItem.leftBarButtonItem!!.title = text
            BarButtonItemScope.TRAILING -> controller.navigationItem.rightBarButtonItem!!.title = text
        }
    } else if (view is UIButton) {
        view.setTitle(text, 0)
        color?.let { view.setTitleColor(it.toUIColor(), 0) }
        view.titleLabel?.font = (style ?: TextStyle()).toUIFont(overrideFontSize = if (fontSize != TextUnit.Unspecified) fontSize else null,
            overrideFontStyle = fontStyle, overrideFontWeight = fontWeight, overrideFontFamily = fontFamily)
        modifier.setup(view)
    } else if (view is ComposeTextField) {
        view.placeholder = text
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
            modifier.padding(0.dp).margin(0.dp).setup(label)
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
        fun createOrReuse(contentIdentifier: String): ComposeLabel {
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