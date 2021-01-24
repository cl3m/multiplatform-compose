package com.rouge41.kmm.compose

import cocoapods.YogaKit.*
import kotlinx.cinterop.ExportObjCClass
import kotlinx.cinterop.ObjCAction
import kotlinx.cinterop.cValue
import kotlinx.cinterop.useContents
import platform.CoreGraphics.CGRectZero
import platform.Foundation.NSLog
import platform.Foundation.NSSelectorFromString
import platform.UIKit.*

actual class SoftwareKeyboardController
actual enum class ImeAction {
    Unspecified, NoAction, Go, Search, Send, Previous, Next, Done
}

actual class KeyboardOptions {
    actual companion object {
        actual val Default: KeyboardOptions
            get() = KeyboardOptions()
    }
}

actual interface VisualTransformation {
    actual companion object {
        actual val None: VisualTransformation
            get() = iosVisualTransformation()
    }
}

class iosVisualTransformation: VisualTransformation

@Composable
actual fun TextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier,
    textStyle: TextStyle,
    label: @Composable (() -> Unit)?,
    placeholder: @Composable (() -> Unit)?,
    leadingIcon: @Composable (() -> Unit)?,
    trailingIcon: @Composable (() -> Unit)?,
    isErrorValue: Boolean,
    visualTransformation: VisualTransformation,
    keyboardOptions: KeyboardOptions,
    singleLine: Boolean,
    maxLines: Int,
    onImeActionPerformed: ((ImeAction, SoftwareKeyboardController?) -> Unit)?,
    onTextInputStarted: ((SoftwareKeyboardController) -> Unit)?,
    interactionState: InteractionState?,
    activeColor: Color?,
    inactiveColor: Color?,
    errorColor: Color?,
    backgroundColor: Color?,
    shape: Shape?
) {
    val container = UIComposeView.createOrReuse("${onValueChange::class}")
    modifier.setup(container)
    addSubview(container) {
        val textField = ComposeTextField.createOrReuse(getCurrentController(), onValueChange)
        textField.text = value
        modifier.padding(0.dp).margin(0.dp).setup(textField)
        addSubview(textField) {
            placeholder?.invoke()
        }
    }
}

@ExportObjCClass
class ComposeTextField(val controller: UIViewController, val onValueChange: (String) -> Unit) : UITextField(frame = cValue { CGRectZero }), UITextFieldDelegateProtocol {
    val contentIdentifier: String = "${onValueChange::class}"
    var isDirty: Boolean = false
    val tap = UITapGestureRecognizer()

    init {
        if (DEBUG_COMPOSE) NSLog("🔴 [init ComposeTextField] $contentIdentifier")
        delegate = this
        addTarget(this, NSSelectorFromString("editingChanged:"), UIControlEventEditingChanged)
        tap.addTarget(this, NSSelectorFromString("dismiss"))
    }

    companion object {
        fun createOrReuse(controller: UIViewController, onValueChange: (String) -> Unit): ComposeTextField {
            for (view in getCurrentView().subviews) {
                if (view is ComposeTextField && view.isDirty && view.contentIdentifier == "${onValueChange::class}") {
                    if (DEBUG_COMPOSE) NSLog("🟢 [reuse ComposeTextField] ${view.contentIdentifier}")
                    view.isDirty = false
                    return view
                }
            }
            return ComposeTextField(controller, onValueChange)
        }
    }

    @ObjCAction
    fun editingChanged(textField: ComposeTextField) {
        onValueChange.invoke(textField.text ?: "")
    }

    override fun textFieldDidBeginEditing(textField: UITextField) {
        NSLog("🎉 start ${superview}")
        controller.view.addGestureRecognizer(tap)
    }

    override fun textFieldDidEndEditing(textField: UITextField) {
        NSLog("🎉 end")
        controller.view.removeGestureRecognizer(tap)
    }

    @ObjCAction
    fun dismiss() {
        NSLog("🎉 dismiss")
        resignFirstResponder()
    }
}