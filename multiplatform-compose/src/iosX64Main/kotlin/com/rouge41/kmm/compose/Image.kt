package com.rouge41.kmm.compose

import cocoapods.YogaKit.*
import platform.Foundation.NSData
import platform.Foundation.NSLog
import platform.Foundation.NSURL
import platform.Foundation.dataWithContentsOfURL
import platform.UIKit.*
import platform.darwin.DISPATCH_QUEUE_PRIORITY_DEFAULT
import platform.darwin.dispatch_async
import platform.darwin.dispatch_get_global_queue
import platform.darwin.dispatch_get_main_queue
import platform.posix.intptr_t
import kotlin.native.concurrent.freeze

actual interface ImageBitmap
data class iosImageBitmap(val id: ImageResource): ImageBitmap {
    fun toUIImage(): UIImage? {
        return UIImage.imageNamed(id)
    }
}
actual typealias ImageResource = String

actual interface ContentScale{
    actual companion object {
        actual val Fit: ContentScale = iosContentScale.Fit
    }
}

sealed class iosContentScale: ContentScale {
    object Fit: iosContentScale()
}

@Composable
actual fun imageResource(id: ImageResource): ImageBitmap = iosImageBitmap(id)

@Composable
actual inline fun Image(bitmap: ImageBitmap,
                        modifier: Modifier,
                        alignment: AlignmentVerticalAndHorizontal,
                        contentScale: ContentScale,
                        alpha: Float) {
    val imageView = UIImageView()
    imageView.image = (bitmap as iosImageBitmap).toUIImage()
    imageView.contentMode = UIViewContentMode.UIViewContentModeScaleAspectFit
    modifier.setup(imageView)
    addSubview(imageView)
}

@Composable
actual inline fun Image(url: String, modifier: Modifier,
                        alignment: AlignmentVerticalAndHorizontal,
                        contentScale: ContentScale,
                        alpha: Float) {
    val imageView = UIImageView()
    imageView.contentMode = UIViewContentMode.UIViewContentModeScaleAspectFit
    modifier.setup(imageView)
    addSubview(imageView)
    dispatch_async(dispatch_get_main_queue()) {
        //TODO: Make it on another thread and handle errors
        val imageUrl = NSURL.URLWithString("$url")
        val data = NSData.dataWithContentsOfURL(imageUrl!!)
        imageView.image = UIImage.imageWithData(data!!)
    }
}