package com.rouge41.kmm.compose.test.demos

import com.rouge41.kmm.compose.foundation.layout.Arrangement
import com.rouge41.kmm.compose.foundation.layout.Column
import com.rouge41.kmm.compose.material.Text
import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.test.Platform
import com.rouge41.kmm.compose.ui.Alignment
import com.rouge41.kmm.compose.ui.Modifier
import com.rouge41.kmm.compose.ui.fillMaxSize

@Composable
fun HelloPlatform() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Hello, ${Platform().platform}!")
    }
}