package com.rouge41.kmm.compose.material

import com.rouge41.kmm.compose.ui.Modifier
import com.rouge41.kmm.compose.ui.fillMaxWidth
import com.rouge41.kmm.compose.foundation.layout.Arrangement
import com.rouge41.kmm.compose.foundation.layout.Column
import com.rouge41.kmm.compose.ui.padding
import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ui.Alignment
import com.rouge41.kmm.compose.ui.unit.dp

@Composable
actual fun ListItem(modifier: Modifier, text: @Composable () -> Unit) {
    Column(
        modifier = modifier.fillMaxWidth().padding(15.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start) {
        text.invoke()
    }
}