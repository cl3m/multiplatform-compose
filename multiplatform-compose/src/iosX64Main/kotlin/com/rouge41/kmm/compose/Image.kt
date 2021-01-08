package com.rouge41.kmm.compose

import cocoapods.YogaKit.*
import platform.UIKit.*

actual typealias ImageResource = String

@Composable
actual inline fun Image(resourceId: ImageResource, modifier: Modifier) {
    val imageView = UIImageView()
    imageView.image = UIImage.imageNamed(resourceId)
    imageView.contentMode = UIViewContentMode.UIViewContentModeScaleAspectFit
    modifier.setup(imageView)
    addSubview(imageView)
}
