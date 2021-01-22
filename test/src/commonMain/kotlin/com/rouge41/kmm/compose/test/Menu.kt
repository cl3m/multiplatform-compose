package com.rouge41.kmm.compose.test

import com.rouge41.kmm.compose.*

@Composable
fun Menu(state: MutableState<Boolean>, onClick: (String) -> Unit) {
    LazyColumn {
        items(Demo.values().dropLast(4)) { item ->
            Text(item.toString(), modifier = Modifier.clickable { onClick.invoke(item.toString()) })
            Divider()
        }
    }
}