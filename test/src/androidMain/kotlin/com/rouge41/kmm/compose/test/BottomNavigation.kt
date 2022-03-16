package com.rouge41.kmm.compose.test

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import com.rouge41.kmm.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.navigation.compose.*
import com.rouge41.kmm.compose.foundation.lazy.LazyColumn
import com.rouge41.kmm.compose.material.Text
import com.rouge41.kmm.compose.runtime.MutableState
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
                val currentRoute = navController.currentBackStackEntry?.destination?.route
                Tab.values().forEach { screen ->
                    BottomNavigationItem(
                        icon = { Icon(screen.icon(), screen.name) },
                        label = { Text(screen.toString(), style = TextStyle(color = Color.White)) },
                        selected = currentRoute == screen.toString(),
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
                composable(screen.toString(), content = {
                    when (screen) {
                        Tab.Tab1 -> Navigation(state, resources)
                        /*Tab.Tab2 -> {
                            LazyColumn {
                                Text("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus dui erat, consequat eget felis malesuada, gravida pellentesque massa. Suspendisse id aliquet ex. Praesent diam dui, consectetur et orci eu, interdum cursus tortor. Aenean quis laoreet lectus, quis consectetur orci. Quisque ac diam varius, malesuada lacus varius, semper nulla. Ut vitae faucibus justo. Fusce nibh tortor, pulvinar viverra urna et, porttitor viverra ipsum. Proin et lacus ac leo lacinia tempus. Suspendisse dictum tortor nec efficitur faucibus.")
                                Counter()
                                Lorem()
                            }
                        }*/
                        Tab.Tab3 -> Layout ()
                        Tab.Tab4 -> Counter ()
                    }
                })
            }
        }
    }
}
