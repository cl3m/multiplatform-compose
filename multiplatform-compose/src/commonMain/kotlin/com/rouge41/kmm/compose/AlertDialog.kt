package com.rouge41.kmm.compose

expect interface DialogProperties

@Composable
expect fun AlertDialog(
    onDismissRequest: () -> Unit,
    confirmButton: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    dismissButton: @Composable (() -> Unit)? = null,
    title: @Composable (() -> Unit)? = null,
    text: @Composable (() -> Unit)? = null,
    shape: Shape? = null,
    backgroundColor: Color? = null,
    contentColor: Color? = null,
    properties: DialogProperties? = null
)