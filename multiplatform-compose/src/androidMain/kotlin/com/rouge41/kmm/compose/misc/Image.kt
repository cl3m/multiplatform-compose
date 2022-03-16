package com.rouge41.kmm.compose.misc

import android.graphics.drawable.Drawable
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.core.graphics.drawable.toBitmap
import coil.ImageLoader
import coil.request.ImageRequest
import com.rouge41.kmm.compose.ui.Modifier
import com.rouge41.kmm.compose.foundation.*
import com.rouge41.kmm.compose.foundation.layout.Column
import com.rouge41.kmm.compose.runtime.mutableStateOf
import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.runtime.*
import com.rouge41.kmm.compose.ui.Alignment
import com.rouge41.kmm.compose.ui.AlignmentVerticalAndHorizontal
import com.rouge41.kmm.compose.ui.layout.ContentScale

@Composable
@Suppress("ACTUAL_FUNCTION_WITH_DEFAULT_ARGUMENTS")
actual inline fun Image(url: String, modifier: Modifier = Modifier,
                        alignment: AlignmentVerticalAndHorizontal = Alignment.Center,
                        contentScale: ContentScale = ContentScale.Fit,
                        alpha: Float = 1.0f) {
    var image by remember { mutableStateOf<Drawable?>(null) }

    if (image != null ) {
        Image(
            bitmap = image!!.toBitmap().asImageBitmap(),
            modifier = modifier,
            alignment = alignment,
            contentScale = contentScale,
            alpha = alpha
        )
    } else {
        val request = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .target { drawable ->
                image = drawable
            }
            .build()
        ImageLoader(LocalContext.current).enqueue(request)
        Column(modifier = modifier) {}
    }
}