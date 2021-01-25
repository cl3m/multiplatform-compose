package com.rouge41.kmm.compose.ui.graphics

import platform.UIKit.UIImage

actual interface ImageBitmap
actual typealias ImageResource = String

data class iosImageBitmap(val id: ImageResource): ImageBitmap {
    fun toUIImage(): UIImage? {
        return UIImage.imageNamed(id)
    }
}

