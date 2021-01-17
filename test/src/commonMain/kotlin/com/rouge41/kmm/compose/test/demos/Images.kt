package com.rouge41.kmm.compose.test.demos

import com.rouge41.kmm.compose.*
import com.rouge41.kmm.compose.test.Resources

@Composable
fun Images(resources: Resources) {
    Column {
        Image(bitmap = imageResource(resources.logo), modifier = Modifier.width(200.dp).height(300.dp).background(Color.LightGray))
        Image("https://loremflickr.com/320/240/ocean", modifier = Modifier.preferredSize(200.dp).background(Color.Black))
    }
}
