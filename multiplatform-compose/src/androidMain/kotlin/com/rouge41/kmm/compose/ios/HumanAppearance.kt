package com.rouge41.kmm.compose.ios

import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ui.graphics.Color

@Composable
actual fun HumanAppearance(tintColor: Color, backgroundColor: Color?, content: @Composable () -> Unit) = content()
