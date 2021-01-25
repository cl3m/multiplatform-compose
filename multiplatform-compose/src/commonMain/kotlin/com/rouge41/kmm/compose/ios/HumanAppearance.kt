package com.rouge41.kmm.compose.ios

import com.rouge41.kmm.compose.ui.graphics.Color
import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ui.text.TextStyle

@Composable
expect fun HumanAppearance(tintColor: Color, backgroundColor: Color?, style: TextStyle, content: @Composable () -> Unit)
