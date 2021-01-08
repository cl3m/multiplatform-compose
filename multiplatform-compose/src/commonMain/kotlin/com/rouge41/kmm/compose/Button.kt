package com.rouge41.kmm.compose

expect interface ButtonColors
expect object ButtonDefaults

@Composable
expect fun ButtonDefaults.buttonColors(backgroundColor: Color): ButtonColors

@Composable
expect fun ButtonDefaults.buttonColors(): ButtonColors

@Composable
expect fun Button(
    onClick: () -> Unit,
    modifier: Modifier,
    colors: ButtonColors,
    content: @Composable RowScope.() -> Unit
)

@Composable
expect fun Button(
    onClick: () -> Unit,
    colors: ButtonColors,
    content: @Composable RowScope.() -> Unit
)

@Composable
expect fun Button(
    onClick: () -> Unit,
    content: @Composable RowScope.() -> Unit
)
