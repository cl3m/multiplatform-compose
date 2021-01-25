package com.rouge41.kmm.compose.test

import com.rouge41.kmm.compose.foundation.isSystemInDarkTheme
import com.rouge41.kmm.compose.ios.HumanAppearance
import com.rouge41.kmm.compose.material.MaterialTheme
import com.rouge41.kmm.compose.material.darkColors
import com.rouge41.kmm.compose.material.lightColors
import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ui.graphics.Color
import com.rouge41.kmm.compose.ui.text.TextStyle
import com.rouge41.kmm.compose.ui.unit.sp

@Composable
fun Theme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val orange = Color(0xFFFF8C00)
    val colors = if (darkTheme) {
        darkColors(primary = orange)
    } else {
        lightColors(primary = orange)
    }

    MaterialTheme(
        colors = colors,
    ) {
        HumanAppearance(
            tintColor = orange,
            backgroundColor = null,
            style = TextStyle(fontSize = 17.sp)
        ) {
            content()
        }
    }
}
