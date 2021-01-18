package com.rouge41.kmm.compose.test

import com.rouge41.kmm.compose.*
import com.rouge41.kmm.compose.test.demos.Counter
import com.rouge41.kmm.compose.test.demos.Layout
import com.rouge41.kmm.compose.test.demos.Lorem
import kotlinx.cinterop.useContents
import platform.Foundation.NSProcessInfo
import platform.Foundation.NSSelectorFromString
import platform.UIKit.*

fun Tab.image(): UIImage? {
    return if (NSProcessInfo.processInfo.operatingSystemVersion.useContents { majorVersion } >= 13) {
        when (this) {
            Tab.Tab1 -> UIImage.systemImageNamed("a.circle.fill")
            Tab.Tab2 -> UIImage.systemImageNamed("b.circle.fill")
            Tab.Tab3 -> UIImage.systemImageNamed("c.circle.fill")
            Tab.Tab4 -> UIImage.systemImageNamed("d.circle.fill")
        }
    } else {
        UIImage()
    }
}

@Composable
actual fun BottomNavigation(state: MutableState<Boolean>, resources: Resources) {
    TabView {
        Tab.values().forEach { tab ->
            Tab(title = tab.toString(), image = tab.image()) {
                when (tab) {
                    Tab.Tab1 -> Navigation(state, resources)
                    Tab.Tab2 -> {
                        ScrollableColumn() {
                            Text("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus dui erat, consequat eget felis malesuada, gravida pellentesque massa. Suspendisse id aliquet ex. Praesent diam dui, consectetur et orci eu, interdum cursus tortor. Aenean quis laoreet lectus, quis consectetur orci. Quisque ac diam varius, malesuada lacus varius, semper nulla. Ut vitae faucibus justo. Fusce nibh tortor, pulvinar viverra urna et, porttitor viverra ipsum. Proin et lacus ac leo lacinia tempus. Suspendisse dictum tortor nec efficitur faucibus.")
                            Column(modifier = Modifier.height(200.dp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally) {
                                Counter()
                            }
                            Image(bitmap = imageResource(resources.logo), modifier = Modifier.width(100.dp).height(100.dp))
                            Lorem()
                        }
                    }
                    Tab.Tab3 -> Layout ()
                    Tab.Tab4 -> SafeArea { Layout () }
                }
            }
        }
    }
}
