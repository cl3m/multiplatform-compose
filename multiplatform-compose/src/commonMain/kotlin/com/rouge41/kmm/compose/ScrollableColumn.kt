package com.rouge41.kmm.compose

expect class ScrollState

@Composable
expect fun ScrollableColumn(
    modifier: Modifier = Modifier,
    scrollState: ScrollState = rememberScrollState(0f),
    verticalArrangement: ArrangementVertical = Arrangement.Top,
    horizontalAlignment: AlignmentHorizontal = Alignment.Start,
    reverseScrollDirection: Boolean = false,
    isScrollEnabled: Boolean = true,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    content: @Composable ColumnScope.() -> Unit
)

@Composable
expect fun rememberScrollState(
    initial: Float = 0f,
    interactionState: InteractionState? = null
): ScrollState