package com.rouge41.kmm.compose.test

import com.rouge41.kmm.compose.*
import platform.UIKit.*

fun Page.image(): UIImage? {
    return when (this) {
        Page.Page1 -> UIImage.systemImageNamed("a.circle.fill")
        Page.Page2 -> UIImage.systemImageNamed("b.circle.fill")
        Page.Page3 -> UIImage.systemImageNamed("c.circle.fill")
        Page.Page4 -> UIImage.systemImageNamed("d.circle.fill")
    }
}

@Composable
actual fun BottomNavigation() {
    TabView {
        Page.values().forEach { page ->
            Tab(title = page.toString(), image = page.image()) {
                when (page) {
                    Page.Page1 -> {
                        ScrollableColumn() {
                            Text("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus dui erat, consequat eget felis malesuada, gravida pellentesque massa. Suspendisse id aliquet ex. Praesent diam dui, consectetur et orci eu, interdum cursus tortor. Aenean quis laoreet lectus, quis consectetur orci. Quisque ac diam varius, malesuada lacus varius, semper nulla. Ut vitae faucibus justo. Fusce nibh tortor, pulvinar viverra urna et, porttitor viverra ipsum. Proin et lacus ac leo lacinia tempus. Suspendisse dictum tortor nec efficitur faucibus.")
                            Column(modifier = Modifier.height(200.dp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally) {
                                Counter()
                            }
                            Lorem()
                        }
                    }
                    Page.Page2 -> Counter ()
                    Page.Page3 -> Layout ()
                    Page.Page4 -> SafeArea { Layout () }
                }
            }
        }
    }
}
