package com.rouge41.kmm.compose.ui.layout

actual interface ContentScale{
    actual companion object {
        actual val Fit: ContentScale = iosContentScale.Fit
    }
}

sealed class iosContentScale: ContentScale {
    object Fit: iosContentScale()
}