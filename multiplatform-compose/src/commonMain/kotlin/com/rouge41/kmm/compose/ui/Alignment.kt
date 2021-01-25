package com.rouge41.kmm.compose.ui

expect interface AlignmentVerticalAndHorizontal
expect interface AlignmentVertical
expect interface AlignmentHorizontal
expect object Alignment {
    val TopStart: AlignmentVerticalAndHorizontal
    val TopCenter: AlignmentVerticalAndHorizontal
    val TopEnd: AlignmentVerticalAndHorizontal
    val CenterStart: AlignmentVerticalAndHorizontal
    val Center: AlignmentVerticalAndHorizontal
    val CenterEnd: AlignmentVerticalAndHorizontal
    val BottomStart: AlignmentVerticalAndHorizontal
    val BottomCenter: AlignmentVerticalAndHorizontal
    val BottomEnd: AlignmentVerticalAndHorizontal
    val Top: AlignmentVertical
    val CenterVertically: AlignmentVertical
    val Bottom: AlignmentVertical
    val Start: AlignmentHorizontal
    val CenterHorizontally: AlignmentHorizontal
    val End: AlignmentHorizontal
}
