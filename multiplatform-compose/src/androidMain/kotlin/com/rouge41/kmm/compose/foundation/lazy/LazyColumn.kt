package com.rouge41.kmm.compose.foundation.lazy

import com.rouge41.kmm.compose.ui.Modifier
import com.rouge41.kmm.compose.foundation.layout.PaddingValues
import com.rouge41.kmm.compose.foundation.InteractionState
import com.rouge41.kmm.compose.foundation.layout.Arrangement
import com.rouge41.kmm.compose.foundation.layout.ArrangementVertical
import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ui.Alignment
import com.rouge41.kmm.compose.ui.AlignmentHorizontal
import com.rouge41.kmm.compose.ui.unit.dp
import androidx.compose.foundation.lazy.rememberLazyListState as _rememberLazyListState
import androidx.compose.foundation.lazy.LazyColumn as _LazyColumn

actual typealias LazyListState = androidx.compose.foundation.lazy.LazyListState
actual typealias LazyItemScope = androidx.compose.foundation.lazy.LazyItemScope
@Suppress("NO_ACTUAL_CLASS_MEMBER_FOR_EXPECTED_CLASS")
actual typealias LazyListScope = androidx.compose.foundation.lazy.LazyListScope

@Suppress("ACTUAL_FUNCTION_WITH_DEFAULT_ARGUMENTS")
@Composable
actual fun LazyColumn(
    modifier: Modifier = Modifier,
    state: LazyListState = rememberLazyListState(),
    contentPadding: PaddingValues = PaddingValues(0.dp),
    reverseLayout: Boolean = false,
    verticalArrangement: ArrangementVertical =
        if (!reverseLayout) Arrangement.Top else Arrangement.Bottom,
    horizontalAlignment: AlignmentHorizontal = Alignment.Start,
    content: LazyListScope.() -> Unit
) = _LazyColumn(modifier = modifier, state = state, contentPadding = contentPadding, reverseLayout = reverseLayout,
    verticalArrangement = verticalArrangement, horizontalAlignment = horizontalAlignment, content = content)

@Suppress("ACTUAL_FUNCTION_WITH_DEFAULT_ARGUMENTS")
@Composable
actual fun rememberLazyListState(
    initialFirstVisibleItemIndex: Int = 0,
    initialFirstVisibleItemScrollOffset: Int = 0,
    interactionState: InteractionState? = null
): LazyListState =_rememberLazyListState(initialFirstVisibleItemIndex = initialFirstVisibleItemIndex, initialFirstVisibleItemScrollOffset = initialFirstVisibleItemScrollOffset, interactionState = interactionState)