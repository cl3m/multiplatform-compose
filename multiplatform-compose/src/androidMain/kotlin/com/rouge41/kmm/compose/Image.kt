package com.rouge41.kmm.compose

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.ContextAmbient
import androidx.core.graphics.drawable.toBitmap
import coil.ImageLoader
import coil.request.ImageRequest
import androidx.compose.foundation.Image as _Image
import androidx.compose.ui.res.imageResource as _imageResource

actual typealias ImageBitmap = androidx.compose.ui.graphics.ImageBitmap
actual typealias ImageResource = Int
actual typealias ContentScale = androidx.compose.ui.layout.ContentScale

@Composable
actual fun imageResource(id: ImageResource): ImageBitmap = _imageResource(id = id)

@Composable
@Suppress("ACTUAL_FUNCTION_WITH_DEFAULT_ARGUMENTS")
actual inline fun Image(bitmap: ImageBitmap,
                        modifier: Modifier = Modifier,
                        alignment: AlignmentVerticalAndHorizontal = Alignment.Center,
                        contentScale: ContentScale = ContentScale.Fit,
                        alpha: Float = 1.0f) = _Image(bitmap = bitmap, modifier = modifier, alignment = alignment, contentScale = contentScale, alpha = alpha)

@Composable
@Suppress("ACTUAL_FUNCTION_WITH_DEFAULT_ARGUMENTS")
actual inline fun Image(url: String, modifier: Modifier = Modifier,
                        alignment: AlignmentVerticalAndHorizontal = Alignment.Center,
                        contentScale: ContentScale = ContentScale.Fit,
                        alpha: Float = 1.0f) {
    var image by remember { mutableStateOf<Drawable?>(null)}

    if (image != null ) {
        _Image(bitmap = image!!.toBitmap().asImageBitmap(), modifier = modifier, alignment = alignment, contentScale = contentScale, alpha = alpha)
    } else {
        val request = ImageRequest
            .Builder(ContextAmbient.current)
            .data(url)
            .target { drawable ->
                image = drawable
            }
            .build()
        ImageLoader(ContextAmbient.current).enqueue(request)
        Column(modifier = modifier) {}
    }
}