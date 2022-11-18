package com.rouge41.kmm.compose.test.demos

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.rememberNavigator

@Composable
internal fun BottomNavigationDemo() {
    val navigator = rememberNavigator()
    val navBackStackEntry by navigator.currentEntry.collectAsState(null)
    val currentRoute = navBackStackEntry?.route?.route ?: ""
    Scaffold(
        bottomBar = {
            BottomNavigation {
                Tab.values().forEach { screen ->
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = null
                            )
                        },
                        label = { Text(screen.toString()) },
                        selected = currentRoute == screen.toString(),
                        onClick = {
                            navigator.navigate(route = screen.toString())
                        },
                        selectedContentColor = MaterialTheme.colors.onPrimary,
                        unselectedContentColor = MaterialTheme.colors.onPrimary.copy(alpha = 0.5f)
                    )
                }
            }
        }
    ) {
        NavHost(navigator = navigator, initialRoute = Tab.values().first().toString()) {
            Tab.values().forEach { screen ->
                scene(screen.toString()) {
                    when (screen) {
                        Tab.Tab1 -> HelloPlatform()
                        Tab.Tab2 -> Layout()
                        Tab.Tab3 -> Counter()
                    }
                }
            }
        }
    }
}

enum class Tab {
    Tab1,
    Tab2,
    Tab3
}
