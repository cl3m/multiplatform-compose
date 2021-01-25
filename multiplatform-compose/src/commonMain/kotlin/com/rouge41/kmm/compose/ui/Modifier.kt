package com.rouge41.kmm.compose.ui

import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ui.graphics.Color
import com.rouge41.kmm.compose.ui.unit.Dp

expect interface Modifier {
    companion object : Modifier { }
}
expect fun Modifier.fillMaxSize(): Modifier
expect fun Modifier.fillMaxWidth(): Modifier
expect fun Modifier.fillMaxHeight(): Modifier
expect fun Modifier.padding(dp: Dp): Modifier
expect fun Modifier.background(color: Color): Modifier
expect fun Modifier.width(dp: Dp): Modifier
expect fun Modifier.height(dp: Dp): Modifier
expect fun Modifier.preferredWidth(dp: Dp): Modifier
expect fun Modifier.preferredHeight(dp: Dp): Modifier
expect fun Modifier.preferredSize(dp: Dp): Modifier
@Composable
expect fun Modifier.clickable(onClick: () -> Unit): Modifier