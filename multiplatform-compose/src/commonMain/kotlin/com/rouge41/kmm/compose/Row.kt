package com.rouge41.kmm.compose

expect interface RowScope

@Composable
expect fun Row(
    modifier: Modifier,
    horizontalArrangement: ArrangementHorizontal,
    verticalAlignment: AlignmentVertical,
    content: @Composable RowScope.() -> Unit
)

@Composable
expect fun Row(content: @Composable RowScope.() -> Unit)
