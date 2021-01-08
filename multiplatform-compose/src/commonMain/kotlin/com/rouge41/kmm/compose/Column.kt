package com.rouge41.kmm.compose

expect interface ColumnScope

@Composable
expect fun Column(
    modifier: Modifier,
    verticalArrangement: ArrangementVertical,
    horizontalAlignment: AlignmentHorizontal,
    content: @Composable ColumnScope.() -> Unit
)

@Composable
expect fun Column(content: @Composable ColumnScope.() -> Unit)
