package com.rouge41.kmm.compose

expect interface ColumnScope

@Composable
expect fun Column(
    modifier: Modifier = Modifier,
    verticalArrangement: ArrangementVertical = Arrangement.Top,
    horizontalAlignment: AlignmentHorizontal = Alignment.Start,
    content: @Composable ColumnScope.() -> Unit
)