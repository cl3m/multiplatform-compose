package com.rouge41.kmm.compose.foundation.layout

import com.rouge41.kmm.compose.ui.unit.Dp
import com.rouge41.kmm.compose.ui.unit.dp
import androidx.compose.foundation.layout.PaddingValues as _PaddingValues

actual typealias PaddingValues = androidx.compose.foundation.layout.PaddingValues

@Suppress("ACTUAL_FUNCTION_WITH_DEFAULT_ARGUMENTS")
actual fun PaddingValues(
    start: Dp = 0.dp,
    top: Dp = 0.dp,
    end: Dp = 0.dp,
    bottom: Dp = 0.dp
): PaddingValues = _PaddingValues(start = start, top = top, end = end, bottom = bottom)

actual fun PaddingValues(all: Dp): PaddingValues = _PaddingValues(all)