package com.rouge41.kmm.compose.material

import com.rouge41.kmm.compose.ui.graphics.Color
import com.rouge41.kmm.compose.ui.Modifier
import com.rouge41.kmm.compose.ui.graphics.Shape
import com.rouge41.kmm.compose.runtime.Composable

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
)