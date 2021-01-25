package com.rouge41.kmm.compose.foundation

import com.rouge41.kmm.compose.ios.DEBUG_COMPOSE
import com.rouge41.kmm.compose.ios.HostingController
import com.rouge41.kmm.compose.ui.Modifier
import com.rouge41.kmm.compose.ios.addSubview
import com.rouge41.kmm.compose.ios.getCurrentView
import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ui.AlignmentVerticalAndHorizontal
import com.rouge41.kmm.compose.ui.graphics.ImageBitmap
import com.rouge41.kmm.compose.ui.graphics.iosImageBitmap
import com.rouge41.kmm.compose.ui.layout.ContentScale
import kotlinx.cinterop.ExportObjCClass
import kotlinx.cinterop.cValue
import platform.CoreGraphics.CGRectZero
import platform.Foundation.NSLog
import platform.UIKit.UIImageView
import platform.UIKit.UIViewContentMode
import platform.UIKit.contentMode
import platform.UIKit.subviews

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