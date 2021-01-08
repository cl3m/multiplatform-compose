package com.rouge41.kmm.compose

@Composable
expect fun HumanAppearance(tintColor: Color, backgroundColor: Color?, style: TextStyle, content: @Composable () -> Unit)
