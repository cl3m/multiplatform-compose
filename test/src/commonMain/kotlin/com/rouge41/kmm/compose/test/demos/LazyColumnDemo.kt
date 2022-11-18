package com.rouge41.kmm.compose.test.demos

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun LazyColumnDemo() {
    val items = (1..25).map { "Line $it" }
    androidx.compose.foundation.lazy.LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            Text("Single\nWith\nMultiple\nLines")
        }
        item {
            Text("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus dui erat, consequat eget felis malesuada, gravida pellentesque massa. Suspendisse id aliquet ex. Praesent diam dui, consectetur et orci eu, interdum cursus tortor. Aenean quis laoreet lectus, quis consectetur orci. Quisque ac diam varius, malesuada lacus varius, semper nulla. Ut vitae faucibus justo. Fusce nibh tortor, pulvinar viverra urna et, porttitor viverra ipsum. Proin et lacus ac leo lacinia tempus. Suspendisse dictum tortor nec efficitur faucibus.")
        }
        items(items) {
            Text(it)
            Divider()
        }
    }
}
