package com.rouge41.kmm.compose.test

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
internal fun Theme(content: @Composable () -> Unit) {
    val orange = Color(0xFFFF8C00)
    val colors = if (DarkMode.current.value) {
        darkColors(primary = orange, surface = orange, onPrimary = Color.White)
    } else {
        lightColors(primary = orange)
    }

    MaterialTheme(
        colors = colors
    ) {
        content()
    }
}
