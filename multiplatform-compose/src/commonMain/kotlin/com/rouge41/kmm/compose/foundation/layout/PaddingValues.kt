package com.rouge41.kmm.compose.foundation.layout

import com.rouge41.kmm.compose.ui.unit.Dp

expect class PaddingValues constructor(start: Dp, top: Dp, end: Dp, bottom: Dp) {
    val start: Dp
    val top: Dp
    val end: Dp
    val bottom: Dp

    constructor(all: Dp)
}