package com.rouge41.kmm.compose

@Composable
expect fun Text(text: String, modifier: Modifier, style: TextStyle)

@Composable
expect fun Text(text: String, style: TextStyle)

@Composable
expect fun Text(text: String, modifier: Modifier)

@Composable
expect fun Text(text: String)
