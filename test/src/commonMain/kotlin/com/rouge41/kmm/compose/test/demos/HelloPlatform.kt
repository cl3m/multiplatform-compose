package com.rouge41.kmm.compose.test.demos

import com.rouge41.kmm.compose.*
import com.rouge41.kmm.compose.test.Platform

@Composable
fun HelloPlatform() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Hello, ${Platform().platform}!")
    }
}