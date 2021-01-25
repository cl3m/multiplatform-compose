package com.rouge41.kmm.compose.foundation

import com.rouge41.kmm.compose.ui.Modifier
import com.rouge41.kmm.compose.foundation.layout.PaddingValues
import com.rouge41.kmm.compose.ui.unit.dp
import com.rouge41.kmm.compose.foundation.layout.Arrangement
import com.rouge41.kmm.compose.foundation.layout.ArrangementVertical
import com.rouge41.kmm.compose.foundation.layout.ColumnScope
import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ui.Alignment
import com.rouge41.kmm.compose.ui.AlignmentHorizontal

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