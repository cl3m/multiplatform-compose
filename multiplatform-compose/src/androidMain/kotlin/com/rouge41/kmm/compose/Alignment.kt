package com.rouge41.kmm.compose

actual typealias AlignmentVerticalAndHorizontal = androidx.compose.ui.Alignment
actual typealias AlignmentVertical = androidx.compose.ui.Alignment.Vertical
actual typealias AlignmentHorizontal = androidx.compose.ui.Alignment.Horizontal

actual object Alignment {
    actual val TopStart: AlignmentVerticalAndHorizontal = androidx.compose.ui.Alignment.TopStart
    actual val TopCenter: AlignmentVerticalAndHorizontal = androidx.compose.ui.Alignment.TopCenter
    actual val TopEnd: AlignmentVerticalAndHorizontal = androidx.compose.ui.Alignment.TopEnd
    actual val CenterStart: AlignmentVerticalAndHorizontal = androidx.compose.ui.Alignment.CenterStart
    actual val Center: AlignmentVerticalAndHorizontal = androidx.compose.ui.Alignment.Center
    actual val CenterEnd: AlignmentVerticalAndHorizontal = androidx.compose.ui.Alignment.CenterEnd
    actual val BottomStart: AlignmentVerticalAndHorizontal = androidx.compose.ui.Alignment.BottomStart
    actual val BottomCenter: AlignmentVerticalAndHorizontal = androidx.compose.ui.Alignment.BottomCenter
    actual val BottomEnd: AlignmentVerticalAndHorizontal = androidx.compose.ui.Alignment.BottomEnd
    actual val Top: AlignmentVertical = androidx.compose.ui.Alignment.Top
    actual val CenterVertically: AlignmentVertical = androidx.compose.ui.Alignment.CenterVertically
    actual val Bottom: AlignmentVertical = androidx.compose.ui.Alignment.Bottom
    actual val Start: AlignmentHorizontal = androidx.compose.ui.Alignment.Start
    actual val CenterHorizontally: AlignmentHorizontal = androidx.compose.ui.Alignment.CenterHorizontally
    actual val End: AlignmentHorizontal = androidx.compose.ui.Alignment.End
}
