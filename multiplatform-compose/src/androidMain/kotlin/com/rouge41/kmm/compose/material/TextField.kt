package com.rouge41.kmm.compose.material

import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.AmbientTextStyle
import androidx.compose.material.ContainerAlpha
import com.rouge41.kmm.compose.ui.text.TextStyle
import com.rouge41.kmm.compose.foundation.InteractionState
import com.rouge41.kmm.compose.foundation.text.KeyboardOptions
import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.runtime.remember
import com.rouge41.kmm.compose.ui.Modifier
import com.rouge41.kmm.compose.ui.graphics.Color
import com.rouge41.kmm.compose.ui.graphics.Shape
import com.rouge41.kmm.compose.ui.text.SoftwareKeyboardController
import com.rouge41.kmm.compose.ui.text.input.ImeAction
import com.rouge41.kmm.compose.ui.text.input.VisualTransformation

@Composable
@Suppress("ACTUAL_FUNCTION_WITH_DEFAULT_ARGUMENTS")
actual fun TextField(
        value: String,
        onValueChange: (String) -> Unit,
        modifier: Modifier = Modifier,
        textStyle: TextStyle = AmbientTextStyle.current,
        label: @Composable (() -> Unit)? = null,
        placeholder: @Composable (() -> Unit)? = null,
        leadingIcon: @Composable (() -> Unit)? = null,
        trailingIcon: @Composable (() -> Unit)? = null,
        isErrorValue: Boolean = false,
        visualTransformation: VisualTransformation = VisualTransformation.None,
        keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
        singleLine: Boolean = false,
        maxLines: Int = Int.MAX_VALUE,
        onImeActionPerformed: ((ImeAction, SoftwareKeyboardController?) -> Unit)? = null, // { _, _ -> },
        onTextInputStarted: ((SoftwareKeyboardController) -> Unit)? = null, //{},
        interactionState: InteractionState? = null, // remember { InteractionState() },
        activeColor: Color? = null, // MaterialTheme.colors.primary,
        inactiveColor: Color? = null, // MaterialTheme.colors.onSurface,
        errorColor: Color? = null, // MaterialTheme.colors.error,
        backgroundColor: Color? = null, // MaterialTheme.colors.onSurface.copy(alpha = ContainerAlpha),
        shape: Shape? = null // MaterialTheme.shapes.small.copy(bottomLeft = ZeroCornerSize, bottomRight = ZeroCornerSize)*/
) = androidx.compose.material.TextField(value = value, onValueChange = onValueChange, modifier = modifier, textStyle = textStyle, label = label,
        placeholder = placeholder, leadingIcon = leadingIcon, trailingIcon = trailingIcon, isErrorValue = isErrorValue, visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions, singleLine = singleLine, maxLines = maxLines, onImeActionPerformed = onImeActionPerformed
        ?: { _, _ -> },
        onTextInputStarted = onTextInputStarted ?: {}, interactionState = interactionState
        ?: remember { InteractionState() },
        activeColor = activeColor ?: MaterialTheme.colors.primary, inactiveColor = inactiveColor
        ?: MaterialTheme.colors.onSurface,
        errorColor = errorColor ?: MaterialTheme.colors.error, backgroundColor = backgroundColor
        ?: MaterialTheme.colors.onSurface.copy(alpha = ContainerAlpha),
        shape = shape
                ?: MaterialTheme.shapes.small.copy(bottomLeft = ZeroCornerSize, bottomRight = ZeroCornerSize))