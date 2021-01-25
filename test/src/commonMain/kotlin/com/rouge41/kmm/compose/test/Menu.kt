package com.rouge41.kmm.compose.test

import com.rouge41.kmm.compose.foundation.lazy.LazyColumn
import com.rouge41.kmm.compose.material.Divider
import com.rouge41.kmm.compose.material.Text
import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.runtime.MutableState
import com.rouge41.kmm.compose.ui.Modifier
import com.rouge41.kmm.compose.ui.clickable

@Composable
fun Menu(state: MutableState<Boolean>, onClick: (String) -> Unit) {
    LazyColumn {
        items(Demo.values().dropLast(4)) { item ->
            Text(item.toString(), modifier = Modifier.clickable { onClick.invoke(item.toString()) })
            Divider()
        }
    }
}