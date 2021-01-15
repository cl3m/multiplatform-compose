package com.rouge41.kmm.compose

expect interface RowScope

@Composable
expect fun Row(
        modifier: Modifier = Modifier,
        horizontalArrangement: ArrangementHorizontal = Arrangement.Start,
        verticalAlignment: AlignmentVertical = Alignment.Top,
        content: @Composable RowScope.() -> Unit
)
