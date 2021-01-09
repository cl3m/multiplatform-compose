package com.rouge41.kmm.compose.test

import com.rouge41.kmm.compose.*
import com.rouge41.kmm.compose.test.demos.*

@Composable
actual fun Navigation(state: MutableState<Boolean>, resources: Resources) {
    NavigationView(startDestination = "Main") { navController ->
        composable("Main", "Navigation") {
            SafeArea {
                Menu(state) { route ->
                    navController.navigate(route)
                }
            }
        }
        Demo.values().dropLast(4).forEach { screen ->
            composable(screen.toString(), screen.toString()) {
                when (screen) {
                    Demo.HelloPlatform -> SafeArea { HelloPlatform() }
                    Demo.Lorem -> SafeArea { ScrollableColumn { Lorem() } }
                    Demo.Counter -> SafeArea { Counter() }
                    Demo.BackPress -> SafeArea { BackPress() }
                    Demo.Layout -> Layout()
                    Demo.Images ->  SafeArea { Images(resources) }
                    Demo.TextStyles -> SafeArea { Column { TextStyles() } }
                }
            }
        }
    }
}