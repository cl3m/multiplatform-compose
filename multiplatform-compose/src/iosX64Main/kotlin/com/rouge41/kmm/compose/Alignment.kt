package com.rouge41.kmm.compose

actual interface AlignmentVerticalAndHorizontal
actual interface AlignmentVertical
actual interface AlignmentHorizontal

actual object Alignment {
    actual val TopStart: AlignmentVerticalAndHorizontal = iosAlignment.TopStart
    actual val TopCenter: AlignmentVerticalAndHorizontal = iosAlignment.TopCenter
    actual val TopEnd: AlignmentVerticalAndHorizontal = iosAlignment.TopEnd
    actual val CenterStart: AlignmentVerticalAndHorizontal = iosAlignment.CenterStart
    actual val Center: AlignmentVerticalAndHorizontal = iosAlignment.Center
    actual val CenterEnd: AlignmentVerticalAndHorizontal = iosAlignment.CenterEnd
    actual val BottomStart: AlignmentVerticalAndHorizontal = iosAlignment.BottomStart
    actual val BottomCenter: AlignmentVerticalAndHorizontal = iosAlignment.BottomCenter
    actual val BottomEnd: AlignmentVerticalAndHorizontal = iosAlignment.BottomEnd
    actual val Top: AlignmentVertical = iosAlignmentVertical.Top
    actual val CenterVertically: AlignmentVertical = iosAlignmentVertical.CenterVertically
    actual val Bottom: AlignmentVertical = iosAlignmentVertical.Bottom
    actual val Start: AlignmentHorizontal = iosAlignmentHorizontal.Start
    actual val CenterHorizontally: AlignmentHorizontal = iosAlignmentHorizontal.CenterHorizontally
    actual val End: AlignmentHorizontal = iosAlignmentHorizontal.End
}

enum class iosAlignment : AlignmentVerticalAndHorizontal {
    TopStart,
    TopCenter,
    TopEnd,
    CenterStart,
    Center,
    CenterEnd,
    BottomStart,
    BottomCenter,
    BottomEnd,
}

enum class iosAlignmentVertical : AlignmentVertical {
    Top,
    CenterVertically,
    Bottom,
}

enum class iosAlignmentHorizontal : AlignmentHorizontal {
    Start,
    CenterHorizontally,
    End,
}
