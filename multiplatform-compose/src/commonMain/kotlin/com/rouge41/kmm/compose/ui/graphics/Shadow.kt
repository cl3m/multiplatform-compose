package com.rouge41.kmm.compose.ui.graphics

import com.rouge41.kmm.compose.ui.geometry.Offset

expect class Shadow {
    val color: Color
    val offset: Offset
    val blurRadius: Float
    companion object {
        val None: Shadow
    }
}