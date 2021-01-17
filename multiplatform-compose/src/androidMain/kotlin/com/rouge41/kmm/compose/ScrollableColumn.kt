package com.rouge41.kmm.compose

import androidx.compose.foundation.rememberScrollState as _rememberScrollState
import androidx.compose.foundation.ScrollableColumn as _ScrollableColumn

actual typealias ScrollState = androidx.compose.foundation.ScrollState

@Composable
@Suppress("ACTUAL_FUNCTION_WITH_DEFAULT_ARGUMENTS")
actual fun ScrollableColumn(
    modifier: Modifier = Modifier,
    scrollState: ScrollState = rememberScrollState(0f),
    verticalArrangement: ArrangementVertical = Arrangement.Top,
    horizontalAlignment: AlignmentHorizontal = Alignment.Start,
    reverseScrollDirection: Boolean = false,
    isScrollEnabled: Boolean = true,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    content: @Composable ColumnScope.() -> Unit
) {
    _ScrollableColumn(modifier = modifier, scrollState = scrollState, verticalArrangement = verticalArrangement, horizontalAlignment = horizontalAlignment,
        reverseScrollDirection = reverseScrollDirection, isScrollEnabled = isScrollEnabled, contentPadding = contentPadding, content = content)
}

@Composable
@Suppress("ACTUAL_FUNCTION_WITH_DEFAULT_ARGUMENTS")
actual fun rememberScrollState(
    initial: Float = 0f,
    interactionState: InteractionState? = null
): ScrollState = _rememberScrollState(initial = initial, interactionState = interactionState)