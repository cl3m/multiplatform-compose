package com.rouge41.kmm.compose.foundation.layout

import com.rouge41.kmm.compose.ui.unit.Dp

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

    actual fun spacedBy(space: Dp): ArrangementHorizontalOrVertical = iosArrangement.spacedBy(space)
}

sealed class iosArrangementHorizontal : ArrangementHorizontal {
    object Start: iosArrangementHorizontal()
    object End: iosArrangementHorizontal()
}

sealed class iosArrangementVertical : ArrangementVertical {
    object Top: iosArrangementVertical()
    object Bottom: iosArrangementVertical()
}

sealed class iosArrangement : ArrangementVertical, ArrangementHorizontal,
    ArrangementHorizontalOrVertical {
    object Center: iosArrangement()
    object SpaceEvenly: iosArrangement()
    object SpaceBetween: iosArrangement()
    object SpaceAround: iosArrangement()
    data class spacedBy(val space: Dp): iosArrangement()
}
