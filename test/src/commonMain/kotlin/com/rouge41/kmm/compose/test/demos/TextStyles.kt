package com.rouge41.kmm.compose.test.demos

import com.rouge41.kmm.compose.foundation.isSystemInDarkTheme
import com.rouge41.kmm.compose.material.Text
import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ui.graphics.Color

@Composable
fun TextStyles() {
    //Text("I am Cursive Text", style = TextStyle(fontFamily = FontFamily.Cursive))
    //Text("I am Monospace Text", style = TextStyle(fontFamily = FontFamily.Monospace))
    //Text("I am Serif Text", style = TextStyle(fontFamily = FontFamily.Serif))
    //Text("Big text", fontSize = 30.sp)
    Text("Red text", color = Color.Red)
    val darkTheme = isSystemInDarkTheme()
    if (darkTheme) {
        Text("I'm dark text color", color = Color.Green)
    } else {
        Text("I'm light text color", color = Color.Cyan)
    }

}
