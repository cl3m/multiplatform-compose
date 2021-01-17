package com.rouge41.kmm.compose.test

import com.rouge41.kmm.compose.*

@Composable
fun Menu(state: MutableState<Boolean>, onClick: (String) -> Unit) {
    Demo.values().dropLast(4).forEach { screen ->
        ListItem(
            text = {
                Text(screen.toString())
            },
            modifier = Modifier.clickable(
                onClick = {
                    onClick.invoke(screen.toString())
                }
            )
        )
    }
}