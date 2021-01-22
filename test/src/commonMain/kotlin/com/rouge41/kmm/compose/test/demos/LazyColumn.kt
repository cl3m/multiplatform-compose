package com.rouge41.kmm.compose.test.demos

import com.rouge41.kmm.compose.*

@Composable
fun LazyColumn(){
    val items = (1..25).map { "Line $it" }
    LazyColumn(modifier = Modifier.fillMaxSize()) {
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