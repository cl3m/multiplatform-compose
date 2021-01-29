package com.rouge41.kmm.compose.foundation.layout

import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ui.Alignment
import com.rouge41.kmm.compose.ui.AlignmentVertical
import com.rouge41.kmm.compose.ui.Modifier

expect interface RowScope {
        fun Modifier.weight(weight: Float, fill: Boolean = true): Modifier
}

@Composable
expect fun Row(
        modifier: Modifier = Modifier,
        horizontalArrangement: ArrangementHorizontal = Arrangement.Start,
        verticalAlignment: AlignmentVertical = Alignment.Top,
        content: @Composable RowScope.() -> Unit
)
