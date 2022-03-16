package com.rouge41.kmm.compose.ui

import androidx.compose.ui.graphics.Shape
import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ui.graphics.Color
import com.rouge41.kmm.compose.ui.unit.Dp
import androidx.compose.foundation.background as _background
import androidx.compose.foundation.layout.fillMaxHeight as _fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize as _fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth as _fillMaxWidth
import androidx.compose.foundation.layout.height as _height
import androidx.compose.foundation.layout.padding as _padding
import androidx.compose.foundation.layout.width as _width
import androidx.compose.foundation.layout.size as _size
import androidx.compose.foundation.clickable as _clickable
import androidx.compose.ui.draw.clip as _clip
import androidx.compose.foundation.layout.aspectRatio as _aspectRatio

@Suppress("NO_ACTUAL_CLASS_MEMBER_FOR_EXPECTED_CLASS")
actual typealias Modifier = androidx.compose.ui.Modifier
actual fun Modifier.fillMaxSize(): Modifier = _fillMaxSize()
actual fun Modifier.fillMaxWidth(): Modifier = _fillMaxWidth()
actual fun Modifier.fillMaxHeight(): Modifier = _fillMaxHeight()
actual fun Modifier.padding(dp: Dp): Modifier = _padding(dp)
//actual fun Modifier.padding(start: Dp, top: Dp, end: Dp, bottom: Dp): Modifier = _padding(start, top, end, bottom)
actual fun Modifier.background(color: Color): Modifier = _background(color)
actual fun Modifier.width(dp: Dp): Modifier = _width(dp)
actual fun Modifier.height(dp: Dp): Modifier = _height(dp)
actual fun Modifier.size(dp: Dp): Modifier = _size(dp)
@Composable
actual fun Modifier.clickable(onClick: () -> Unit): Modifier = _clickable(onClick = onClick)
actual fun Modifier.clip(shape: Shape): Modifier = _clip(shape = shape)
actual fun Modifier.aspectRatio(ratio: Float, matchHeightConstraintsFirst: Boolean): Modifier = _aspectRatio(ratio, matchHeightConstraintsFirst)