package com.rouge41.kmm.compose.material

import cocoapods.YogaKit.*
import com.rouge41.kmm.compose.foundation.BorderStroke
import com.rouge41.kmm.compose.foundation.InteractionState
import com.rouge41.kmm.compose.foundation.layout.PaddingValues
import com.rouge41.kmm.compose.foundation.layout.RowScope
import com.rouge41.kmm.compose.foundation.layout.iosRowScope
import com.rouge41.kmm.compose.foundation.shape.RoundedCornerShape
import com.rouge41.kmm.compose.ios.*
import com.rouge41.kmm.compose.navigation.BarButtonItemScope
import com.rouge41.kmm.compose.navigation.UIComposeViewController
import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ui.Modifier
import com.rouge41.kmm.compose.ui.background
import com.rouge41.kmm.compose.ui.graphics.Color
import com.rouge41.kmm.compose.ui.graphics.Shape
import com.rouge41.kmm.compose.ui.graphics.SolidColor
import com.rouge41.kmm.compose.ui.padding
import com.rouge41.kmm.compose.ui.unit.Dp
import com.rouge41.kmm.compose.ui.unit.dp
import kotlinx.cinterop.*
import platform.CoreGraphics.CGRectZero
import platform.Foundation.NSLog
import platform.Foundation.NSSelectorFromString
import platform.UIKit.*

actual interface ButtonColors
actual object ButtonDefaults {
    actual val outlinedBorder = BorderStroke(1.dp, Color.Tint)
    actual val ContentPadding = PaddingValues(8.dp)
    actual val TextButtonContentPadding = PaddingValues(16.dp, 8.dp, 16.dp, 8.dp)

    @Composable
    actual fun elevation(defaultElevation: Dp, pressedElevation: Dp, disabledElevation: Dp): ButtonElevation = iosButtonElevation()
}

class DefaultButtonColors(
    val backgroundColor: com.rouge41.kmm.compose.ui.graphics.Color = Color.Unspecified,
    val disabledBackgroundColor: com.rouge41.kmm.compose.ui.graphics.Color = Color.Unspecified,
    val contentColor: com.rouge41.kmm.compose.ui.graphics.Color? = null,
    val disabledContentColor: com.rouge41.kmm.compose.ui.graphics.Color? = null
) : ButtonColors

@Composable
actual fun ButtonDefaults.buttonColors(backgroundColor: com.rouge41.kmm.compose.ui.graphics.Color): ButtonColors = DefaultButtonColors(backgroundColor, backgroundColor.copy(alpha = 0.12))

@Composable
actual fun ButtonDefaults.buttonColors(): ButtonColors = DefaultButtonColors()

@Composable
actual fun ButtonDefaults.outlinedButtonColors(): ButtonColors = DefaultButtonColors()

@Composable
actual fun ButtonDefaults.textButtonColors(): ButtonColors = DefaultButtonColors()

@Composable
actual fun Button(
        onClick: () -> Unit,
        modifier: Modifier,
        enabled: Boolean,
        interactionState: InteractionState?,
        elevation: ButtonElevation?,
        shape: Shape?,
        border: BorderStroke?,
        colors: ButtonColors?,
        contentPadding: PaddingValues?,
        content: @Composable RowScope.() -> Unit
) {
    val controller = getCurrentController()
    if (controller is ComposeAlertController) {
        controller.onClick = onClick
        content.invoke(iosRowScope())
    } else if (controller is UIComposeViewController && controller.barButtonItemScope != BarButtonItemScope.NONE) {
        when (controller.barButtonItemScope) {
            BarButtonItemScope.LEADING -> controller.navigationItem.leftBarButtonItem = ComposeBarButtonItem(onClick)
            BarButtonItemScope.TRAILING -> controller.navigationItem.rightBarButtonItem = ComposeBarButtonItem(onClick)
        }
        content.invoke(iosRowScope())
    } else {
        val container = ComposeSystemButton.createOrReuse(onClick)
        modifier.padding(0.dp).setup(container)
        modifier.background(Color.Transparent).setup(container.button)
        if (border != null) {
            if (border.brush is SolidColor) {
                container.layer.borderColor = border.brush.value.toUIColor()?.CGColor
            }
            container.layer.borderWidth = border.width.value.toDouble()
        } else {
            container.layer.borderWidth = 0.0
        }
        if (shape != null && shape is RoundedCornerShape) {
            if (colors != null && colors is DefaultButtonColors) {
                colors.backgroundColor.toUIColor()?.let { container.backgroundColor = it }
            } else {
                container.backgroundColor = getHostingView().tintColor
                container.button.tintColor = UIColor.whiteColor
                container.button.titleLabel?.textColor = UIColor.whiteColor
            }
            //TODO: Use UIBezierPath
            container.layer.cornerRadius = (shape.topLeft as Dp).value.toDouble()
        }
        if (colors != null && colors is DefaultButtonColors) {
            colors.backgroundColor.toUIColor()?.let { container.backgroundColor = it }
        }
        container.button.enabled = enabled
        addSubview(container) {
            addSubview(container.button) { content.invoke(iosRowScope()) }
        }
    }
}

// in a container because system button are not subclassable
@ExportObjCClass
class ComposeSystemButton(val contentIdentifier: String, val onClick: () -> Unit) : UIView(frame = cValue { CGRectZero }) {
    var isDirty: Boolean = false
    var button: UIButton = UIButton.buttonWithType(1)
    private var initialBackgroundColor: UIColor? = null

    init {
        if (DEBUG_COMPOSE) NSLog("🔴 [init ComposeSystemButton] $contentIdentifier")
        configureLayoutWithBlock { layout ->
            layout?.isEnabled = true
            layout?.flexDirection = YGFlexDirection.YGFlexDirectionColumn
            layout?.justifyContent = YGJustify.YGJustifyFlexStart
            layout?.alignItems = YGAlign.YGAlignFlexStart
            layout?.padding = YGPointValue(0.0)
            layout?.margin = YGPointValue(0.0)
        }
        button.addTarget(this, NSSelectorFromString("touchDown"), UIControlEventTouchDown)
        button.addTarget(this, NSSelectorFromString("touchUpInside"), UIControlEventTouchUpInside)
        button.addTarget(this, NSSelectorFromString("touchUpOutside"), UIControlEventTouchUpOutside)
        addSubview(button)
        button.configureLayoutWithBlock { layout ->
            layout?.isEnabled = true
            layout?.minHeight = YGPointValue(44.0)
            layout?.minWidth = YGPointValue(44.0)
        }
    }

    companion object {
        fun createOrReuse(onClick: () -> Unit): ComposeSystemButton {
            val contentIdentifier = "${onClick::class}"
            for (view in getCurrentView().subviews) {
                if (view is ComposeSystemButton && view.isDirty && view.contentIdentifier == contentIdentifier) {
                    if (DEBUG_COMPOSE) NSLog("🟢 [reuse ComposeSystemButton] ${view.contentIdentifier}")
                    view.isDirty = false
                    return view
                }
            }
            return ComposeSystemButton(contentIdentifier, onClick)
        }
    }

    @ObjCAction
    fun touchUpInside() {
        backgroundColor = initialBackgroundColor
        onClick()
    }

    @ObjCAction
    fun touchUpOutside() {
        backgroundColor = initialBackgroundColor
    }

    @ObjCAction
    fun touchDown() {
        initialBackgroundColor = backgroundColor
        if (backgroundColor != null && backgroundColor != Color.Transparent.toUIColor()) {
            backgroundColor = backgroundColor?.colorWithAlphaComponent(0.5)
        }
    }
}

actual interface ButtonElevation
class iosButtonElevation : ButtonElevation

@Composable
actual fun OutlinedButton(
        onClick: () -> Unit,
        modifier: Modifier,
        enabled: Boolean,
        interactionState: InteractionState?,
        elevation: ButtonElevation?,
        shape: Shape?,
        border: BorderStroke?,
        colors: ButtonColors?,
        contentPadding: PaddingValues?,
        content: @Composable RowScope.() -> Unit
) = Button(
    onClick = onClick,
    modifier = modifier,
    enabled = enabled,
    interactionState = interactionState,
    elevation = elevation,
    shape = shape ?: MaterialTheme.shapes.small,
    border = border,
    colors = colors ?: ButtonDefaults.outlinedButtonColors(),
    contentPadding = contentPadding ?: ButtonDefaults.ContentPadding,
    content = content
)

@Composable
actual fun TextButton(
        onClick: () -> Unit,
        modifier: Modifier,
        enabled: Boolean,
        interactionState: InteractionState?,
        elevation: ButtonElevation?,
        shape: Shape?,
        border: BorderStroke?,
        colors: ButtonColors?,
        contentPadding: PaddingValues?,
        content: @Composable RowScope.() -> Unit
) = Button(
    onClick = onClick,
    modifier = modifier,
    enabled = enabled,
    interactionState = interactionState,
    elevation = elevation,
    shape = shape ?: MaterialTheme.shapes.small,
    border = border,
    colors = colors ?: ButtonDefaults.textButtonColors(),
    contentPadding = contentPadding ?: ButtonDefaults.TextButtonContentPadding,
    content = content
)

@ExportObjCClass
class ComposeBarButtonItem(val onClick: () -> Unit) : UIBarButtonItem() {
    init {
        setPrimaryAction(UIAction.actionWithTitle("<title>", null, null) {
            onClick()
        })
    }
}