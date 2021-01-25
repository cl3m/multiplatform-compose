package com.rouge41.kmm.compose.ui.text.font

actual data class FontWeight(val weight: Int) {
    actual companion object {
        actual val W100 = FontWeight(100)
        actual val W200 = FontWeight(200)
        actual val W300 = FontWeight(300)
        actual val W400 = FontWeight(400)
        actual val W500 = FontWeight(500)
        actual val W600 = FontWeight(600)
        actual val W700 = FontWeight(700)
        actual val W800 = FontWeight(800)
        actual val W900 = FontWeight(900)
        actual val Thin = W100
        actual val ExtraLight = W200
        actual val Light = W300
        actual val Normal = W400
        actual val Medium = W500
        actual val SemiBold = W600
        actual val Bold = W700
        actual val ExtraBold = W800
        actual val Black = W900
    }
}