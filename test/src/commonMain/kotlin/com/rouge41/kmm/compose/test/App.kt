package com.rouge41.kmm.compose.test

import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.runtime.MutableState
import com.rouge41.kmm.compose.test.demos.HelloPlatform

@Composable
fun App(state: MutableState<Boolean>, resources: Resources) {
    BottomNavigation(state, resources)
}