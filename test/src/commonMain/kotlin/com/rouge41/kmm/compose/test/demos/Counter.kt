package com.rouge41.kmm.compose.test.demos

import com.rouge41.kmm.compose.foundation.layout.Arrangement
import com.rouge41.kmm.compose.foundation.layout.Column
import com.rouge41.kmm.compose.foundation.layout.Row
import com.rouge41.kmm.compose.foundation.layout.Spacer
import com.rouge41.kmm.compose.material.Button
import com.rouge41.kmm.compose.material.Text
import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.runtime.mutableStateOf
import com.rouge41.kmm.compose.runtime.remember
import com.rouge41.kmm.compose.ui.*
import com.rouge41.kmm.compose.ui.unit.dp

@Composable
fun Counter(modifier: Modifier = Modifier.fillMaxSize()) {
    var count = remember { mutableStateOf<Int>(0) }
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "${count.value}", modifier = Modifier.height(50.dp))
        Row {
            Button(onClick = { count.value = count.value + 1 }) {
                Text("+")
            }
            Spacer(Modifier.width(15.dp))
            Button(onClick = { count.value = count.value - 1 }) {
                Text("-")
            }
        }
    }
}