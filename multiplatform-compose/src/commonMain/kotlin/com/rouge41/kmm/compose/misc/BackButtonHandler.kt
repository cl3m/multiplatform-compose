package com.rouge41.kmm.compose.misc

import com.rouge41.kmm.compose.runtime.Composable

@Composable
expect fun BackButtonHandler(onBackPressed: () -> Unit)
