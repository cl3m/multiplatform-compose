package com.rouge41.kmm.compose.test

import com.rouge41.kmm.compose.*

@Composable
fun HelloPlatform() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Hello, ${Platform().platform}!")
    }
}