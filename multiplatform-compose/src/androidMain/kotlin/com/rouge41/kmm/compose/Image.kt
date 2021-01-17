package com.rouge41.kmm.compose

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.ContextAmbient
import androidx.core.graphics.drawable.toBitmap
import coil.ImageLoader
import coil.request.ImageRequest
import androidx.compose.foundation.Image as _Image
import androidx.compose.ui.res.imageResource as _imageResource

actual typealias ImageResource = Int
actual typealias ContentScale = androidx.compose.ui.layout.ContentScale

@Composable
@Suppress("ACTUAL_FUNCTION_WITH_DEFAULT_ARGUMENTS")
actual inline fun Image(resourceId: ImageResource,
                        modifier: Modifier = Modifier,
                        alignment: AlignmentVerticalAndHorizontal = Alignment.Center,
                        contentScale: ContentScale = ContentScale.Fit,
                        alpha: Float = 1.0f) = _Image(bitmap = _imageResource(id = resourceId), modifier = modifier, alignment = alignment, contentScale = contentScale, alpha = alpha)

@Composable
actual inline fun Image(url: String, modifier: Modifier) {
    var image by remember { mutableStateOf<Drawable?>(null)}

    if (image != null ) {
        _Image(bitmap = image!!.toBitmap().asImageBitmap(), modifier = modifier)
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