package com.rouge41.kmm.compose

@Composable
actual fun HumanAppearance(tintColor: Color, backgroundColor: Color?, style: TextStyle, content: @Composable () -> Unit) = content()
