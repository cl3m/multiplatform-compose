package com.rouge41.kmm.compose.material

import com.rouge41.kmm.compose.ui.text.TextStyle
import com.rouge41.kmm.compose.foundation.InteractionState
import com.rouge41.kmm.compose.foundation.text.KeyboardOptions
import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ui.Modifier
import com.rouge41.kmm.compose.ui.graphics.Color
import com.rouge41.kmm.compose.ui.graphics.Shape
import com.rouge41.kmm.compose.ui.text.SoftwareKeyboardController
import com.rouge41.kmm.compose.ui.text.input.ImeAction
import com.rouge41.kmm.compose.ui.text.input.VisualTransformation

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