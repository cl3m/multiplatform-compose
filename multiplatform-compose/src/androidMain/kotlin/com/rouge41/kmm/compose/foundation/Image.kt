package com.rouge41.kmm.compose.foundation

import androidx.compose.ui.graphics.ImageBitmap
import com.rouge41.kmm.compose.ui.Modifier
import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ui.Alignment
import com.rouge41.kmm.compose.ui.AlignmentVerticalAndHorizontal
import com.rouge41.kmm.compose.ui.layout.ContentScale
import androidx.compose.foundation.Image as _Image

@Composable
@Suppress("ACTUAL_FUNCTION_WITH_DEFAULT_ARGUMENTS")
actual inline fun Image(bitmap: ImageBitmap,
                        modifier: Modifier = Modifier,
                        alignment: AlignmentVerticalAndHorizontal = Alignment.Center,
                        contentScale: ContentScale = ContentScale.Fit,
                        alpha: Float = 1.0f) = _Image(
    bitmap = bitmap,
    modifier = modifier,
    alignment = alignment,
    contentScale = contentScale,
    alpha = alpha
)