package com.rouge41.kmm.compose

expect interface VisualTransformation {
    companion object {
        val None: VisualTransformation
    }
}

expect class KeyboardOptions {
    companion object {
        val Default: KeyboardOptions
    }
}

expect enum class ImeAction {
    Unspecified,
    NoAction,
    Go,
    Search,
    Send,
    Previous,
    Next,
    Done
}

expect class SoftwareKeyboardController

@Composable
expect fun TextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle(),
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    isErrorValue: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    singleLine: Boolean = false,
    maxLines: Int = Int.MAX_VALUE,
    onImeActionPerformed: ((ImeAction, SoftwareKeyboardController?) -> Unit)? = null,
    onTextInputStarted: ((SoftwareKeyboardController) -> Unit)? = null,
    interactionState: InteractionState? = null,
    activeColor: Color? = null,
    inactiveColor: Color? = null,
    errorColor: Color? = null,
    backgroundColor: Color? = null,
    shape: Shape? = null,
)