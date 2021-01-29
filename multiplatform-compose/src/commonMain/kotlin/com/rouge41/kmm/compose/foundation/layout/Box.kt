package com.rouge41.kmm.compose.foundation.layout

import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ui.Alignment
import com.rouge41.kmm.compose.ui.AlignmentVerticalAndHorizontal
import com.rouge41.kmm.compose.ui.Modifier

expect interface BoxScope

@Composable
expect fun Box(
    modifier: Modifier = Modifier,
    contentAlignment: AlignmentVerticalAndHorizontal = Alignment.TopStart,
    content: @Composable BoxScope.() -> Unit
)