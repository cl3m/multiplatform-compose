package com.rouge41.kmm.compose.foundation.layout

import androidx.compose.foundation.layout.InternalLayoutApi

@OptIn(InternalLayoutApi::class)
actual typealias ArrangementVertical = androidx.compose.foundation.layout.Arrangement.Vertical
@OptIn(InternalLayoutApi::class)
actual typealias ArrangementHorizontal = androidx.compose.foundation.layout.Arrangement.Horizontal
@OptIn(InternalLayoutApi::class)
actual typealias ArrangementHorizontalOrVertical = androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical

actual object Arrangement {
    actual val Start: ArrangementHorizontal = androidx.compose.foundation.layout.Arrangement.Start
    actual val End: ArrangementHorizontal = androidx.compose.foundation.layout.Arrangement.End
    actual val Top: ArrangementVertical = androidx.compose.foundation.layout.Arrangement.Top
    actual val Bottom: ArrangementVertical = androidx.compose.foundation.layout.Arrangement.Bottom
    actual val Center: ArrangementHorizontalOrVertical = androidx.compose.foundation.layout.Arrangement.Center
    actual val SpaceEvenly: ArrangementHorizontalOrVertical = androidx.compose.foundation.layout.Arrangement.SpaceEvenly
    actual val SpaceBetween: ArrangementHorizontalOrVertical = androidx.compose.foundation.layout.Arrangement.SpaceBetween
    actual val SpaceAround: ArrangementHorizontalOrVertical = androidx.compose.foundation.layout.Arrangement.SpaceAround
}
