package com.rouge41.kmm.compose.ui.graphics

expect sealed class Brush

expect class SolidColor: Brush {
    val value: Color
}