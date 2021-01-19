package com.rouge41.kmm.compose

import cocoapods.YogaKit.*
import kotlinx.cinterop.ExportObjCClass
import kotlinx.cinterop.ObjCAction
import kotlinx.cinterop.cValue
import platform.CoreGraphics.CGRectZero
import platform.Foundation.*
import platform.UIKit.*
import platform.darwin.*
import platform.posix.intptr_t
import platform.posix.printf
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
    val imageView = ComposeImageView.createOrReuse(bitmap = bitmap)
    modifier.setup(imageView)
    addSubview(imageView)
}

@Composable
actual inline fun Image(url: String,
                        modifier: Modifier,
                        alignment: AlignmentVerticalAndHorizontal,
                        contentScale: ContentScale,
                        alpha: Float) {
    val imageView = ComposeImageView.createOrReuse(url = url)
    modifier.setup(imageView)
    addSubview(imageView)
}

@ExportObjCClass
class ComposeImageView(bitmap: ImageBitmap?, val url: String?) : UIImageView(frame = cValue { CGRectZero }) {
    var isDirty: Boolean = false
    var contentIdentifier: String

    init {
        contentIdentifier = contentIdentifier(bitmap, url)
        if (DEBUG_COMPOSE) NSLog("🔴 [init ComposeImageView] $contentIdentifier")
        bitmap?.let { image = (it as iosImageBitmap).toUIImage() }
        url?.let { HostingController.host.imageViewLoader(this, url) }
        contentMode = UIViewContentMode.UIViewContentModeScaleAspectFit
    }

    companion object {
        fun createOrReuse(bitmap: ImageBitmap? = null, url: String? = null): ComposeImageView {
            for (view in getCurrentView().subviews) {
                if (view is ComposeImageView && view.isDirty && view.contentIdentifier == contentIdentifier(bitmap, url)) {
                    if (DEBUG_COMPOSE) NSLog("🟢 [reuse ComposeImageView] ${view.contentIdentifier}")
                    view.isDirty = false
                    return view
                }
            }
            return ComposeImageView(bitmap = bitmap, url = url)
        }

        private fun contentIdentifier(bitmap: ImageBitmap?, url: String?): String {
            return if (bitmap != null) {
                "$bitmap"
            } else url ?: throw Exception("contentIdentifier undefined")
        }
    }
}
