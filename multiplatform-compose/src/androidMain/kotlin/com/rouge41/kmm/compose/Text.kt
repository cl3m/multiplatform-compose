package com.rouge41.kmm.compose

import androidx.compose.material.Text as _Text

@Composable
actual fun Text(text: String, modifier: Modifier, style: TextStyle) = _Text(text = text, modifier = modifier, style = style)

@Composable
actual fun Text(text: String, style: TextStyle) = _Text(text = text, style = style)

@Composable
actual fun Text(text: String, modifier: Modifier) = _Text(text = text, modifier = modifier)

@Composable
actual fun Text(text: String) = _Text(text = text)
