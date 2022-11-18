package com.rouge41.kmm.compose.test.demos

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.unit.dp
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.utils.io.core.*
import com.rouge41.kmm.compose.toImageBitmap

@Composable
internal fun Images() {
    Column {
        AsyncImage(
            url = "https://loremflickr.com/320/320/ocean",
            modifier = Modifier.size(200.dp).background(Color.Black)
        )
    }
}

@Composable
internal fun AsyncImage(
    url: String,
    contentDescription: String? = "",
    modifier: Modifier = Modifier
) {
    var image by remember { mutableStateOf<ImageBitmap?>(null) }
    image?.let {
        androidx.compose.foundation.Image(
            modifier = modifier,
            bitmap = it,
            contentDescription = contentDescription
        )
    } ?: run {
        Spacer(modifier = modifier)
    }
    LaunchedEffect(key1 = url, block = {
        val bytes: ByteArray = HttpClient().use { client ->
            client.get(url).body()
        }
        image = bytes.toImageBitmap()
    })
}
