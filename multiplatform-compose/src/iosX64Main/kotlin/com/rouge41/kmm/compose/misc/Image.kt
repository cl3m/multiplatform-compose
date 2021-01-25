package com.rouge41.kmm.compose.misc

import com.rouge41.kmm.compose.foundation.ComposeImageView
import com.rouge41.kmm.compose.ios.addSubview
import com.rouge41.kmm.compose.ui.Modifier
import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ui.AlignmentVerticalAndHorizontal
import com.rouge41.kmm.compose.ui.layout.ContentScale

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