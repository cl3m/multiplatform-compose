package com.rouge41.kmm.compose.test

import com.rouge41.kmm.compose.*

@Composable
fun Images(resources: Resources) {
    Image(resourceId = resources.logo, modifier = Modifier.width(200.dp).height(300.dp).background(Color.LightGray))
}
