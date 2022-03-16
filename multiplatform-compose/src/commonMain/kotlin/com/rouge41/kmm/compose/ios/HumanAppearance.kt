package com.rouge41.kmm.compose.ios

import com.rouge41.kmm.compose.ui.graphics.Color
import com.rouge41.kmm.compose.runtime.Composable

@Composable
expect fun HumanAppearance(tintColor: Color, backgroundColor: Color?, content: @Composable () -> Unit)
