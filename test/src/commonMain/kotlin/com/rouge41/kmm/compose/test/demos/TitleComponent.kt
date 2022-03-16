package com.rouge41.kmm.compose.test.demos

import com.rouge41.kmm.compose.material.Text
import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ui.Modifier
import com.rouge41.kmm.compose.ui.fillMaxWidth
import com.rouge41.kmm.compose.ui.graphics.Color
import com.rouge41.kmm.compose.ui.padding
import com.rouge41.kmm.compose.ui.unit.dp

@Composable
fun TitleComponent(title: String) {
    // Text is a predefined composable that does exactly what you'd expect it to - display text on
    // the screen. It allows you to customize its appearance using style, fontWeight, fontSize, etc.
    Text(
        title,
        modifier = Modifier.padding(16.dp).fillMaxWidth()
    )
}
