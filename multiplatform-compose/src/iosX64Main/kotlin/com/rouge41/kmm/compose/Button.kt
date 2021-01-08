package com.rouge41.kmm.compose

import cocoapods.YogaKit.*
import kotlinx.cinterop.*
import platform.CoreGraphics.CGRect
import platform.CoreGraphics.CGRectZero
import platform.Foundation.*
import platform.Foundation.NSSelectorFromString
import platform.UIKit.*
import platform.darwin.NSObject

actual interface ButtonColors
actual object ButtonDefaults

class iosButtonColors : ButtonColors

@Composable
actual fun ButtonDefaults.buttonColors(backgroundColor: Color): ButtonColors {
    return iosButtonColors()
}

@Composable
actual fun ButtonDefaults.buttonColors(): ButtonColors {
    return iosButtonColors()
}

@Composable
actual fun Button(
    onClick: () -> Unit,
    modifier: Modifier,
    colors: ButtonColors,
    content: @Composable RowScope.() -> Unit
) {
    // in a container because system button are not subclassable
    val container = ButtonContainer(UIButton.buttonWithType(1), onClick)
    modifier.setup(container)
    container.configureLayoutWithBlock { layout ->
        layout?.isEnabled = true
        layout?.flexDirection = YGFlexDirection.YGFlexDirectionColumn
        layout?.justifyContent = YGJustify.YGJustifyFlexStart
        layout?.alignItems = YGAlign.YGAlignFlexStart
        layout?.padding = YGPointValue(0.0)
        layout?.margin = YGPointValue(0.0)
    }
    modifier.setup(container.button)
    addSubview(container) {
        addSubview(container.button) { content.invoke(iosRowScope()) }
    }
}

actual fun Button(
    onClick: () -> Unit,
    colors: ButtonColors,
    content: @Composable RowScope.() -> Unit
) {
    Button(onClick = onClick, modifier = Modifier, colors = colors, content = content)
}

actual fun Button(
    onClick: () -> Unit,
    content: @Composable RowScope.() -> Unit
) {
    Button(onClick = onClick, modifier = Modifier, colors = ButtonDefaults.buttonColors(), content = content)
}

@ExportObjCClass
class ButtonContainer(val button: UIButton, val action: () -> Unit) : UIView(frame = cValue { CGRectZero }) {
    init {
        button.addTarget(
            target = this,
            action = NSSelectorFromString("touchUpInside"),
            forControlEvents = UIControlEventTouchUpInside
        )
        addSubview(button)
        button.configureLayoutWithBlock { layout ->
            layout?.isEnabled = true
        }
    }

    @ObjCAction
    fun touchUpInside() {
        action()
    }
}
