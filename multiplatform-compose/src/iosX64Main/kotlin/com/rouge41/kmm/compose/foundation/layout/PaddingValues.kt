package com.rouge41.kmm.compose.foundation.layout

import com.rouge41.kmm.compose.ui.unit.Dp

actual interface PaddingValues
data class iosPaddingValues(val start: Dp, val top: Dp, val end: Dp, val bottom: Dp) : PaddingValues

actual fun PaddingValues(
    start: Dp,
    top: Dp,
    end: Dp,
    bottom: Dp
): PaddingValues = iosPaddingValues(start = start, top = top, end = end, bottom = bottom)

actual fun PaddingValues(all: Dp): PaddingValues = iosPaddingValues(start = all, top = all, end = all, bottom = all)