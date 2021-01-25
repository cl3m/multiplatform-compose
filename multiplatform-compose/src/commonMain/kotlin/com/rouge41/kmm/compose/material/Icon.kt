package com.rouge41.kmm.compose.material

import com.rouge41.kmm.compose.ui.Modifier
import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ui.graphics.Color
import com.rouge41.kmm.compose.ui.graphics.vector.ImageVector

@Composable
expect fun Icon(
        imageVector: ImageVector,
        modifier: Modifier = Modifier,
        tint: Color? = null
)

expect fun iconArrowBack(): ImageVector