package com.rouge41.kmm.compose.test.demos

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

internal val Counter = compositionLocalOf { mutableStateOf(0) }

@Composable
internal fun Counter(modifier: Modifier = Modifier.fillMaxSize()) {
    var count = Counter.current
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
