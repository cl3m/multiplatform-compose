package com.rouge41.kmm.compose.material

import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ui.Modifier
import com.rouge41.kmm.compose.ui.graphics.Color

@Composable
expect fun Text(
        text: String,
        modifier: Modifier = Modifier,
        color: Color = Color.Unspecified)