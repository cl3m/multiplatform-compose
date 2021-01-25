package com.rouge41.kmm.compose.test

import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.runtime.MutableState

@Composable
expect fun BottomNavigation(state: MutableState<Boolean>, resources: Resources)

enum class Tab {
    Tab1,
    Tab2,
    Tab3,
    Tab4
}