package com.rouge41.kmm.compose

// Do nothing on iOS

@Composable
actual fun Scaffold(
    topBar: @Composable () -> Unit,
    bodyContent: @Composable (PaddingValues) -> Unit
) {
    bodyContent.invoke(PaddingValues(0.dp))
}

@Composable
actual fun TopAppBar(title: @Composable () -> Unit, navigationIcon: @Composable (() -> Unit)?) {

}
