package com.rouge41.kmm.compose

import com.rouge41.kmm.compose.test.Content
import moe.tlaster.precompose.PreComposeApplication

fun RootViewController() = PreComposeApplication(title = "") {
    Content()
}