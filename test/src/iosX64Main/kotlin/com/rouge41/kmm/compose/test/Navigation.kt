package com.rouge41.kmm.compose.test

import com.rouge41.kmm.compose.*

@Composable
actual fun Navigation(resources: Resources) {
    NavigationView(startDestination = "Main") { navController ->
        composable("Main", "Navigation") {
            SafeArea {
                ScrollableColumn {
                    for (content in contents()) {
                        Button(onClick = { navController.navigate(content.toString()) },
                            modifier = Modifier.padding(15.dp).fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors()) {
                            Text(content.toString())
                        }
                    }
                }
            }
        }
        contents().forEach { screen ->
            composable(screen.toString(), screen.toString()) {
                when (screen) {
                    ContentType.HelloPlatform -> SafeArea { HelloPlatform() }
                    ContentType.Lorem -> SafeArea { ScrollableColumn { Lorem() } }
                    ContentType.Counter -> SafeArea { Counter() }
                    ContentType.BackPress -> SafeArea { BackPress() }
                    ContentType.Layout -> Layout()
                    ContentType.Images ->  SafeArea { Images(resources) }
                    ContentType.TextStyles -> SafeArea { Column { TextStyles() } }
                    ContentType.BottomNavigation -> BottomNavigation()
                }
            }
        }
    }
}