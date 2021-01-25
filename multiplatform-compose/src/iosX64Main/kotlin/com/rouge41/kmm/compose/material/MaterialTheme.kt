package com.rouge41.kmm.compose.material

import com.rouge41.kmm.compose.runtime.Composable
import platform.UIKit.*


actual object MaterialTheme {
    actual val colors: Colors = lightColors()
    actual val typography: Typography = Typography()
    actual val shapes: Shapes = Shapes()
}

@Composable
actual fun MaterialTheme(
        colors: Colors?,
        typography: Typography?,
        shapes: Shapes?,
        content: @Composable () -> Unit
) = content.invoke()

