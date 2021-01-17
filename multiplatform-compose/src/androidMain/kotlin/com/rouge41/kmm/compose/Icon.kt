package com.rouge41.kmm.compose

import androidx.compose.material.AmbientContentAlpha
import androidx.compose.material.AmbientContentColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.Icon as _Icon

actual typealias ImageVector = androidx.compose.ui.graphics.vector.ImageVector

@Composable
@Suppress("ACTUAL_FUNCTION_WITH_DEFAULT_ARGUMENTS")
actual fun Icon(
    imageVector: ImageVector,
    modifier: Modifier = Modifier,
    tint: Color? = null
) {
    _Icon(imageVector = imageVector, modifier = modifier, tint = tint ?: AmbientContentColor.current.copy(alpha = AmbientContentAlpha.current))
}

actual fun iconArrowBack(): ImageVector = Icons.Filled.ArrowBack