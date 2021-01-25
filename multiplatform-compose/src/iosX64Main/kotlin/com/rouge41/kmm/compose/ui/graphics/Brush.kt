package com.rouge41.kmm.compose.ui.graphics

actual sealed class Brush

actual data class SolidColor(actual val value: Color) : Brush()
