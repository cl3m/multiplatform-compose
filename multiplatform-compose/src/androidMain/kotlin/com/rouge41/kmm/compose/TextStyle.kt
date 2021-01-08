package com.rouge41.kmm.compose

actual typealias FontWeight = androidx.compose.ui.text.font.FontWeight
actual typealias FontFamily = androidx.compose.ui.text.font.FontFamily
actual typealias TextStyle = androidx.compose.ui.text.TextStyle
actual typealias TextUnit = androidx.compose.ui.unit.TextUnit
actual typealias FontStyle = androidx.compose.ui.text.font.FontStyle

actual inline val Int.sp: TextUnit get() = TextUnit(packedValue = this.toLong())
