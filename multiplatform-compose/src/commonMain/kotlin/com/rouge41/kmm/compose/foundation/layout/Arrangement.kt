package com.rouge41.kmm.compose.foundation.layout

import com.rouge41.kmm.compose.ui.unit.Dp

expect interface ArrangementVertical
expect interface ArrangementHorizontal
expect interface ArrangementHorizontalOrVertical
expect object Arrangement {
    val Start: ArrangementHorizontal
    val End: ArrangementHorizontal
    val Top: ArrangementVertical
    val Bottom: ArrangementVertical
    val Center: ArrangementHorizontalOrVertical
    val SpaceEvenly: ArrangementHorizontalOrVertical
    val SpaceBetween: ArrangementHorizontalOrVertical
    val SpaceAround: ArrangementHorizontalOrVertical

    fun spacedBy(space: Dp): ArrangementHorizontalOrVertical
}
