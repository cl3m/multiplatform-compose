package com.rouge41.kmm.compose.ui.res

import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ui.graphics.ImageBitmap
import com.rouge41.kmm.compose.ui.graphics.ImageResource
import androidx.compose.ui.res.imageResource as _imageResource

@Composable
actual fun imageResource(id: ImageResource): ImageBitmap = _imageResource(id = id)