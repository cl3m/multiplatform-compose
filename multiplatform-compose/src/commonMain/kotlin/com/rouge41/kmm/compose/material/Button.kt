package com.rouge41.kmm.compose.material

import com.rouge41.kmm.compose.foundation.BorderStroke
import com.rouge41.kmm.compose.foundation.InteractionState
import com.rouge41.kmm.compose.foundation.layout.PaddingValues
import com.rouge41.kmm.compose.foundation.layout.RowScope
import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ui.Modifier
import com.rouge41.kmm.compose.ui.graphics.Color
import com.rouge41.kmm.compose.ui.graphics.Shape
import com.rouge41.kmm.compose.ui.unit.Dp
import com.rouge41.kmm.compose.ui.unit.dp

expect interface ButtonColors
expect object ButtonDefaults {
    val outlinedBorder: BorderStroke
    val ContentPadding: PaddingValues
    val TextButtonContentPadding: PaddingValues

    @Composable
    fun elevation(defaultElevation: Dp = 2.dp, pressedElevation: Dp = 8.dp, disabledElevation: Dp = 0.dp): ButtonElevation
}
expect interface ButtonElevation

@Composable
expect fun ButtonDefaults.buttonColors(backgroundColor: Color): ButtonColors

@Composable
expect fun ButtonDefaults.buttonColors(): ButtonColors

@Composable
expect fun ButtonDefaults.outlinedButtonColors(): ButtonColors

@Composable
expect fun ButtonDefaults.textButtonColors(): ButtonColors

@Composable
expect fun Button(
        onClick: () -> Unit,
        modifier: Modifier = Modifier,
        enabled: Boolean = true,
        interactionState: InteractionState? = null,
        elevation: ButtonElevation? = null,
        shape: Shape? = null,
        border: BorderStroke? = null,
        colors: ButtonColors? = null,
        contentPadding: PaddingValues? = null,
        content: @Composable RowScope.() -> Unit
)

@Composable
expect fun OutlinedButton(
        onClick: () -> Unit,
        modifier: Modifier = Modifier,
        enabled: Boolean = true,
        interactionState: InteractionState? = null,
        elevation: ButtonElevation? = null,
        shape: Shape? =  null,
        border: BorderStroke? = ButtonDefaults.outlinedBorder,
        colors: ButtonColors? = null,
        contentPadding: PaddingValues? = null,
        content: @Composable RowScope.() -> Unit
)

@Composable
expect fun TextButton(
        onClick: () -> Unit,
        modifier: Modifier = Modifier,
        enabled: Boolean = true,
        interactionState: InteractionState? = null,
        elevation: ButtonElevation? = null,
        shape: Shape? = null,
        border: BorderStroke? = null,
        colors: ButtonColors? = null,
        contentPadding: PaddingValues? = null,
        content: @Composable RowScope.() -> Unit
)