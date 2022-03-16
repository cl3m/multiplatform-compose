package com.rouge41.kmm.compose.material

import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ui.Modifier

@Composable
@Suppress("ACTUAL_FUNCTION_WITH_DEFAULT_ARGUMENTS")
actual fun TextField(
        value: String,
        onValueChange: (String) -> Unit,
        modifier: Modifier = Modifier,
        label: @Composable (() -> Unit)? = null,
        placeholder: @Composable (() -> Unit)? = null,
) = androidx.compose.material.TextField(value = value, onValueChange = onValueChange, modifier = modifier, label = label,
        placeholder = placeholder)