package com.rouge41.kmm.compose.foundation.layout

import com.rouge41.kmm.compose.ui.Modifier
import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ui.Alignment
import com.rouge41.kmm.compose.ui.AlignmentHorizontal

expect interface ColumnScope

@Composable
expect fun Column(
        modifier: Modifier = Modifier,
        verticalArrangement: ArrangementVertical = Arrangement.Top,
        horizontalAlignment: AlignmentHorizontal = Alignment.Start,
        content: @Composable ColumnScope.() -> Unit
)