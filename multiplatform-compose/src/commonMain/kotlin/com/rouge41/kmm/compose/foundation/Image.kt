package com.rouge41.kmm.compose.foundation

import com.rouge41.kmm.compose.ui.Modifier
import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ui.Alignment
import com.rouge41.kmm.compose.ui.AlignmentVerticalAndHorizontal
import com.rouge41.kmm.compose.ui.graphics.ImageBitmap
import com.rouge41.kmm.compose.ui.layout.ContentScale

@Composable
expect inline fun Image(bitmap: ImageBitmap,
                        modifier: Modifier = Modifier,
                        alignment: AlignmentVerticalAndHorizontal = Alignment.Center,
                        contentScale: ContentScale = ContentScale.Fit,
                        alpha: Float = 1.0f)