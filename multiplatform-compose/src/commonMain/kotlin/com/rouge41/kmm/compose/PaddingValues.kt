package com.rouge41.kmm.compose

expect class PaddingValues constructor(start: Dp, top: Dp, end: Dp, bottom: Dp) {
    val start: Dp
    val top: Dp
    val end: Dp
    val bottom: Dp

    constructor(all: Dp)
}