package com.rouge41.kmm.compose.test

import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.runtime.MutableState

@Composable
expect fun Navigation(state: MutableState<Boolean>, resources: Resources)
