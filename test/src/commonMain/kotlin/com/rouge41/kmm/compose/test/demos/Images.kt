package com.rouge41.kmm.compose.test.demos

import com.rouge41.kmm.compose.*
import com.rouge41.kmm.compose.test.Resources

@Composable
fun Images(resources: Resources) {
    Image(resourceId = resources.logo, modifier = Modifier.width(200.dp).height(300.dp).background(Color.LightGray))
}
