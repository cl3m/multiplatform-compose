package com.rouge41.kmm.compose.foundation.layout

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
}
