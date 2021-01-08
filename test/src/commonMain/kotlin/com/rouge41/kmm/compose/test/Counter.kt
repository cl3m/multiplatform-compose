package com.rouge41.kmm.compose.test

import com.rouge41.kmm.compose.*

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