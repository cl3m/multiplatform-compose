package com.rouge41.kmm.compose.foundation.layout

import com.rouge41.kmm.compose.ui.unit.Dp
import com.rouge41.kmm.compose.ui.unit.dp

expect interface PaddingValues

expect fun PaddingValues(
    start: Dp = 0.dp,
    top: Dp = 0.dp,
    end: Dp = 0.dp,
    bottom: Dp = 0.dp
): PaddingValues

expect fun PaddingValues(all: Dp): PaddingValues