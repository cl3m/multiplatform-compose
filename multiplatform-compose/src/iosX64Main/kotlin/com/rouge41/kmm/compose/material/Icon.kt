package com.rouge41.kmm.compose.material

import com.rouge41.kmm.compose.ui.Modifier
import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ui.graphics.Color
import com.rouge41.kmm.compose.ui.graphics.vector.ImageVector

@Composable
actual fun Icon(
        imageVector: ImageVector,
        modifier: Modifier,
        tint: Color?
) {
}

actual fun iconArrowBack(): ImageVector {
    TODO("Not needed in iOS")
}