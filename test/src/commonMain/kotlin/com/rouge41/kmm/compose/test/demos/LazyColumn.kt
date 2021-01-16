package com.rouge41.kmm.compose.test.demos

import com.rouge41.kmm.compose.*

@Composable
fun LazyColumn(){
    val items = (1..25).map { "Line $it" }
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            Text("Single")
            Text("With")
            Text("Multiple")
            Text("Lines")
        }
        items(items) {
            Text(it, modifier = Modifier.padding(10.dp))
            Divider()
        }
    }
}