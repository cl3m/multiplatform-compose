package com.rouge41.kmm.compose.test.demos

import com.rouge41.kmm.compose.foundation.layout.Column
import com.rouge41.kmm.compose.misc.Image
import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.test.Resources
import com.rouge41.kmm.compose.ui.*
import com.rouge41.kmm.compose.ui.graphics.Color
import com.rouge41.kmm.compose.ui.res.imageResource
import com.rouge41.kmm.compose.ui.unit.dp

@Composable
fun Images(resources: Resources) {
    Column {
        com.rouge41.kmm.compose.foundation.Image(
            bitmap = imageResource(resources.logo),
            modifier = Modifier.width(200.dp).height(300.dp).background(
                Color.LightGray
            )
        )
        Image("https://loremflickr.com/320/240/ocean")
    }
}
