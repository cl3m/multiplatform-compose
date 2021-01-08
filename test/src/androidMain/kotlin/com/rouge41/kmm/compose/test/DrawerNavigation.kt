package com.rouge41.kmm.compose.test

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.navigation.compose.*
import com.rouge41.kmm.compose.SafeArea
import com.rouge41.kmm.compose.ScrollableColumn

@Composable
fun DrawerNavigation(resources: Resources) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(currentRoute ?: "") },
                navigationIcon = {
                    Icon(
                        Icons.Default.Menu,
                        modifier = Modifier.clickable(
                            onClick = {
                                scaffoldState.drawerState.open()
                            }
                        )
                    )
                }
            )
        },
        drawerContent = {
            contents().forEach { screen ->
                ListItem(
                    text = {
                        Text(
                            screen.toString(),
                            style = TextStyle(color = if (currentRoute == screen.toString()) MaterialTheme.colors.primary else Color.Black)
                        )
                    },
                    modifier = Modifier.clickable(
                        onClick = {
                            navController.navigate(screen.toString()) {
                                launchSingleTop = true
                            }
                            scaffoldState.drawerState.close()
                        }
                    )
                )
            }
        },
        scaffoldState = scaffoldState
    ) {
        NavHost(navController, startDestination = contents().first().toString()) {
            contents().forEach { screen ->
                composable(screen.toString()) {
                    when (screen) {
                        ContentType.HelloPlatform -> HelloPlatform()
                        ContentType.Lorem -> ScrollableColumn { Lorem() }
                        ContentType.Counter -> Counter()
                        ContentType.BackPress -> BackPress()
                        ContentType.Layout -> Layout()
                        ContentType.Images ->  Images(resources)
                        ContentType.TextStyles -> Column { TextStyles() }
                        ContentType.BottomNavigation -> BottomNavigation()
                    }
                }
            }
        }
    }
}

@Composable
actual fun Navigation(resources: Resources) = DrawerNavigation(resources)