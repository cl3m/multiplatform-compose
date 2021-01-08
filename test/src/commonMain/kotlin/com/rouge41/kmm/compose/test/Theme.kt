package com.rouge41.kmm.compose.test

import com.rouge41.kmm.compose.*

@Composable
fun Theme(content: @Composable () -> Unit) {
    HumanAppearance(tintColor = Color.Blue, backgroundColor = null, style = TextStyle(fontSize = 17.sp)) {
        content()
    }
}
