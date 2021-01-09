package com.rouge41.kmm.compose.test

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.*
import com.rouge41.kmm.compose.MutableState
import com.rouge41.kmm.compose.test.demos.Counter
import com.rouge41.kmm.compose.test.demos.Layout
import com.rouge41.kmm.compose.test.demos.Lorem

fun Tab.icon(): ImageVector {
    return when (this) {
        Tab.Tab1 -> Icons.Filled.Home
        Tab.Tab2 -> Icons.Filled.Call
        Tab.Tab3 -> Icons.Filled.Info
        Tab.Tab4 -> Icons.Filled.Info
    }
}

@Composable
actual fun BottomNavigation(state: MutableState<Boolean>, resources: Resources) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)
                Tab.values().forEach { screen ->
                    BottomNavigationItem(
                        icon = { Icon(screen.icon()) },
                        label = { Text(screen.toString(), style = TextStyle(color = Color.White)) },
                        selected = currentRoute == screen.toString(),
                        alwaysShowLabels = false,
                        onClick = {
                            navController.navigate(screen.toString()) {
                                launchSingleTop = true
                            }
                        }
                    )
                }
            }
        }
    ) {
        NavHost(navController, startDestination = Tab.values().first().toString()) {
            Tab.values().forEach { screen ->
                composable(screen.toString()) {
                    when (screen) {
                        Tab.Tab1 -> Navigation(state, resources)
                        Tab.Tab2 -> {
                            ScrollableColumn() {
                                Text("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus dui erat, consequat eget felis malesuada, gravida pellentesque massa. Suspendisse id aliquet ex. Praesent diam dui, consectetur et orci eu, interdum cursus tortor. Aenean quis laoreet lectus, quis consectetur orci. Quisque ac diam varius, malesuada lacus varius, semper nulla. Ut vitae faucibus justo. Fusce nibh tortor, pulvinar viverra urna et, porttitor viverra ipsum. Proin et lacus ac leo lacinia tempus. Suspendisse dictum tortor nec efficitur faucibus.")
                                Counter()
                                Lorem()
                                Spacer(modifier = Modifier.height(60.dp))
                            }
                        }
                        Tab.Tab3 -> Layout ()
                        Tab.Tab4 -> Counter ()
                    }
                }
            }
        }
    }
}
