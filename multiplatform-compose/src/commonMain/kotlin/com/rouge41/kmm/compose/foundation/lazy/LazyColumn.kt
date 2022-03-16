package com.rouge41.kmm.compose.foundation.lazy

import com.rouge41.kmm.compose.ui.Modifier
import com.rouge41.kmm.compose.foundation.layout.PaddingValues
import com.rouge41.kmm.compose.foundation.layout.Arrangement
import com.rouge41.kmm.compose.foundation.layout.ArrangementVertical
import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ui.Alignment
import com.rouge41.kmm.compose.ui.AlignmentHorizontal
import com.rouge41.kmm.compose.ui.unit.dp

expect class LazyListState

expect interface LazyItemScope

expect interface LazyListScope {
    fun <T> items(
        items: List<T>,
        itemContent: @Composable LazyItemScope.(item: T) -> Unit
    )

    fun item(content: @Composable LazyItemScope.() -> Unit)

    fun <T> itemsIndexed(
        items: List<T>,
        itemContent: @Composable LazyItemScope.(index: Int, item: T) -> Unit
    )
}

@Composable
expect fun LazyColumn(
        modifier: Modifier = Modifier,
        state: LazyListState = rememberLazyListState(),
        contentPadding: PaddingValues = PaddingValues(0.dp),
        reverseLayout: Boolean = false,
        verticalArrangement: ArrangementVertical =
        if (!reverseLayout) Arrangement.Top else Arrangement.Bottom,
        horizontalAlignment: AlignmentHorizontal = Alignment.Start,
        content: LazyListScope.() -> Unit
)

expect fun rememberLazyListState(
    initialFirstVisibleItemIndex: Int = 0,
    initialFirstVisibleItemScrollOffset: Int = 0,
): LazyListState