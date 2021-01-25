package com.rouge41.kmm.compose.ui.res

import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ui.graphics.ImageBitmap
import com.rouge41.kmm.compose.ui.graphics.ImageResource
import com.rouge41.kmm.compose.ui.graphics.iosImageBitmap

@Composable
actual fun imageResource(id: ImageResource): ImageBitmap = iosImageBitmap(id)