package com.rouge41.kmm.compose

import androidx.compose.foundation.Image as _Image
import androidx.compose.ui.res.imageResource as _imageResource

actual typealias ImageResource = Int

@Composable
actual inline fun Image(resourceId: ImageResource, modifier: Modifier) = _Image(bitmap = _imageResource(id = resourceId), modifier = modifier)
