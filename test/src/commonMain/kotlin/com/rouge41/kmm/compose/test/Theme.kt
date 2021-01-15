package com.rouge41.kmm.compose.test

import com.rouge41.kmm.compose.*

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
        HumanAppearance(tintColor = orange, backgroundColor = null, style = TextStyle(fontSize = 17.sp)) {
            content()
        }
    }
}
