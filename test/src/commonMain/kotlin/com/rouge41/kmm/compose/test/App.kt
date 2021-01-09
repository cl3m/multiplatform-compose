package com.rouge41.kmm.compose.test

import com.rouge41.kmm.compose.Composable
import com.rouge41.kmm.compose.MutableState

@Composable
fun App(state: MutableState<Boolean>, resources: Resources) {
    BottomNavigation(state, resources)
}