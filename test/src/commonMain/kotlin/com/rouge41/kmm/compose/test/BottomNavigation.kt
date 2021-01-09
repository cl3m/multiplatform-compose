package com.rouge41.kmm.compose.test

import com.rouge41.kmm.compose.*

@Composable
expect fun BottomNavigation(state: MutableState<Boolean>, resources: Resources)

enum class Tab {
    Tab1,
    Tab2,
    Tab3,
    Tab4
}