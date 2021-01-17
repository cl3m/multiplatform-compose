package com.rouge41.kmm.compose

import androidx.compose.ui.unit.sp as _sp

actual typealias FontWeight = androidx.compose.ui.text.font.FontWeight
actual typealias FontFamily = androidx.compose.ui.text.font.FontFamily
actual typealias GenericFontFamily = androidx.compose.ui.text.font.GenericFontFamily
actual typealias SystemFontFamily = androidx.compose.ui.text.font.SystemFontFamily
actual typealias TextStyle = androidx.compose.ui.text.TextStyle
actual typealias TextUnit = androidx.compose.ui.unit.TextUnit
actual typealias FontStyle = androidx.compose.ui.text.font.FontStyle

actual inline val Int.sp: TextUnit get() = this._sp
actual inline val Double.sp: TextUnit get() = this._sp

actual typealias FontSynthesis = androidx.compose.ui.text.font.FontSynthesis
actual typealias BaselineShift = androidx.compose.ui.text.style.BaselineShift
actual typealias TextGeometricTransform = androidx.compose.ui.text.style.TextGeometricTransform
actual typealias Locale = androidx.compose.ui.text.intl.Locale
actual typealias LocaleList = androidx.compose.ui.text.intl.LocaleList
actual typealias TextDecoration = androidx.compose.ui.text.style.TextDecoration
actual typealias TextAlign = androidx.compose.ui.text.style.TextAlign
actual typealias Offset = androidx.compose.ui.geometry.Offset
actual typealias Shadow = androidx.compose.ui.graphics.Shadow
actual typealias TextDirection = androidx.compose.ui.text.style.TextDirection
actual typealias TextIndent = androidx.compose.ui.text.style.TextIndent