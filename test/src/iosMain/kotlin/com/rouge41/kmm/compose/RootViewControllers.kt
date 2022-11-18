package com.rouge41.kmm.compose

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.dp
import com.rouge41.kmm.compose.test.Content
import com.rouge41.kmm.compose.test.safeAreaState
import moe.tlaster.precompose.PreComposeApplication
import platform.CoreGraphics.CGFloat

fun RootViewController() = PreComposeApplication(title = "") {
    Content()
}

fun setSafeArea(start: CGFloat, top: CGFloat, end: CGFloat, bottom: CGFloat) {
    safeAreaState.value = PaddingValues(start.dp, top.dp, end.dp, bottom.dp)
}