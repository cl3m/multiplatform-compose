package com.rouge41.kmm.compose.material

import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import com.rouge41.kmm.compose.ui.Modifier
import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ui.graphics.Color
import com.rouge41.kmm.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.Icon as _Icon

@Composable
@Suppress("ACTUAL_FUNCTION_WITH_DEFAULT_ARGUMENTS")
actual fun Icon(
        imageVector: ImageVector,
        modifier: Modifier = Modifier,
        tint: Color? = null
) {
    _Icon(imageVector = imageVector, contentDescription = null, modifier = modifier, tint = tint ?: LocalContentColor.current.copy(alpha = LocalContentAlpha.current))
}

actual fun iconArrowBack(): ImageVector = Icons.Filled.ArrowBack