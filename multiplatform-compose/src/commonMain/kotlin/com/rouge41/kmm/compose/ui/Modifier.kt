package com.rouge41.kmm.compose.ui

import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ui.graphics.Color
import com.rouge41.kmm.compose.ui.graphics.Shape
import com.rouge41.kmm.compose.ui.unit.Dp
import com.rouge41.kmm.compose.ui.unit.dp

expect interface Modifier {
    companion object : Modifier { }
}
expect fun Modifier.fillMaxSize(): Modifier
expect fun Modifier.fillMaxWidth(): Modifier
expect fun Modifier.fillMaxHeight(): Modifier
expect fun Modifier.padding(dp: Dp): Modifier
expect fun Modifier.padding(start: Dp = 0.dp, top: Dp = 0.dp, end: Dp = 0.dp, bottom: Dp = 0.dp): Modifier
expect fun Modifier.background(color: Color): Modifier
expect fun Modifier.width(dp: Dp): Modifier
expect fun Modifier.height(dp: Dp): Modifier
expect fun Modifier.preferredWidth(dp: Dp): Modifier
expect fun Modifier.preferredHeight(dp: Dp): Modifier
expect fun Modifier.preferredSize(dp: Dp): Modifier
@Composable
expect fun Modifier.clickable(onClick: () -> Unit): Modifier
expect fun Modifier.clip(shape: Shape): Modifier
expect fun Modifier.aspectRatio(ratio: Float, matchHeightConstraintsFirst: Boolean = false): Modifier