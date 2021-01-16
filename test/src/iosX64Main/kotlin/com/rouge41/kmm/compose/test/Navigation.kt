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
                    Demo.LazyColumn -> SafeArea { LazyColumn() }
                    Demo.HelloPlatform -> SafeArea { HelloPlatform() }
                    Demo.Lorem -> SafeArea { ScrollableColumn { Lorem() } }
                    Demo.Counter -> Counter()
                    Demo.BackPress -> BackPress()
                    Demo.Layout -> SafeArea { Layout() }
                    Demo.Images ->  SafeArea { Images(resources) }
                    Demo.TextStyles -> SafeArea { Column { TextStyles() } }
                }
            }
        }
    }
}