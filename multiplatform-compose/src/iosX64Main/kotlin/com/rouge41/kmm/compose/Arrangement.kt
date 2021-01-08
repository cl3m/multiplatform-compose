package com.rouge41.kmm.compose

actual interface ArrangementVertical
actual interface ArrangementHorizontal
actual interface ArrangementHorizontalOrVertical : ArrangementHorizontal, ArrangementVertical

actual object Arrangement {
    actual val Start: ArrangementHorizontal = iosArrangementHorizontal.Start
    actual val End: ArrangementHorizontal = iosArrangementHorizontal.End
    actual val Top: ArrangementVertical = iosArrangementVertical.Top
    actual val Bottom: ArrangementVertical = iosArrangementVertical.Bottom
    actual val Center: ArrangementHorizontalOrVertical = iosArrangement.Center
    actual val SpaceEvenly: ArrangementHorizontalOrVertical = iosArrangement.SpaceEvenly
    actual val SpaceBetween: ArrangementHorizontalOrVertical = iosArrangement.SpaceBetween
    actual val SpaceAround: ArrangementHorizontalOrVertical = iosArrangement.SpaceAround
}

enum class iosArrangementHorizontal : ArrangementHorizontal {
    Start,
    End,
}

enum class iosArrangementVertical : ArrangementVertical {
    Top,
    Bottom,
}

enum class iosArrangement : ArrangementVertical, ArrangementHorizontal, ArrangementHorizontalOrVertical {
    Center,
    SpaceEvenly,
    SpaceBetween,
    SpaceAround,
}
