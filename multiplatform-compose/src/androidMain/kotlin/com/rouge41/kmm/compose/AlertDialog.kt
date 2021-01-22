package com.rouge41.kmm.compose

import androidx.compose.material.contentColorFor
import androidx.compose.material.AlertDialog as _AlertDialog

actual typealias DialogProperties = androidx.compose.ui.window.DialogProperties

@Composable
@Suppress("ACTUAL_FUNCTION_WITH_DEFAULT_ARGUMENTS")
actual fun AlertDialog(
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
) = _AlertDialog(onDismissRequest = onDismissRequest, confirmButton = confirmButton, modifier = modifier, dismissButton = dismissButton,
    title = title, text = text, shape = shape ?: MaterialTheme.shapes.medium, backgroundColor = backgroundColor ?: MaterialTheme.colors.surface,
    contentColor = if (backgroundColor != null) contentColorFor(backgroundColor) else contentColorFor(MaterialTheme.colors.surface), properties = properties)