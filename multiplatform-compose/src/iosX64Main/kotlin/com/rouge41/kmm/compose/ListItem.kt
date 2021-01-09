package com.rouge41.kmm.compose

@Composable
actual fun ListItem(modifier: Modifier, text: @Composable () -> Unit) {
    Column(
        modifier = modifier.fillMaxWidth().padding(15.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start) {
        text.invoke()
    }
}