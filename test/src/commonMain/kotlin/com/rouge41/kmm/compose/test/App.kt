package com.rouge41.kmm.compose.test

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.rouge41.kmm.compose.test.demos.*
import com.rouge41.kmm.compose.test.demos.Counter
import com.rouge41.kmm.compose.test.demos.HelloPlatform
import com.rouge41.kmm.compose.test.demos.Layout
import kotlinx.coroutines.launch
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.rememberNavigator

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun App() {
    val scope = rememberCoroutineScope()
    val navigator = rememberNavigator()
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val navBackStackEntry by navigator.currentEntry.collectAsState(null)
    val currentRoute = navBackStackEntry?.route?.route
    Scaffold(
        topBar = {
            Box(modifier = Modifier.background(MaterialTheme.colors.primary)) {
                TopAppBar(
                    modifier = Modifier.padding(top = SafeArea.current.value.calculateTopPadding()),
                    title = { Text(currentRoute ?: "") },
                    navigationIcon = {
                        Icon(
                            Icons.Default.Menu,
                            "test",
                            modifier = Modifier.clickable(
                                onClick = {
                                    scope.launch { scaffoldState.drawerState.open() }
                                }
                            )
                        )
                    }
                )
            }
        },
        drawerContent = {
            LazyColumn(modifier = Modifier.padding(top = SafeArea.current.value.calculateTopPadding())) {
                items(Demo.values().size) {
                    val item = Demo.values()[it]
                    ListItem(
                        text = { Text(item.toString()) },
                        modifier = Modifier.clickable {
                            navigator.navigate(route = item.toString())
                            scope.launch { scaffoldState.drawerState.close() }
                        }
                    )
                    Divider()
                }
            }
        },
        scaffoldState = scaffoldState
    ) {
        NavHost(navigator = navigator, initialRoute = Demo.HelloPlatform.toString()) {
            Demo.values().forEach { screen ->
                scene(screen.toString()) {
                    if (screen == Demo.BottomNavigation) {
                        BottomNavigationDemo()
                    } else {
                        Box(modifier = Modifier.padding(bottom = SafeArea.current.value.calculateBottomPadding())) {
                            when (screen) {
                                Demo.LazyColumn -> LazyColumnDemo()
                                Demo.HelloPlatform -> HelloPlatform()
                                Demo.Lorem -> Lorem()
                                Demo.Counter -> Counter()
                                Demo.Layout -> Layout()
                                Demo.Images -> Images()
                                Demo.Buttons -> Buttons()
                                // Demo.Alert -> Alert()
                                Demo.TextStyles -> Column { TextStyles() }
                                Demo.TextFields -> TextFields()
                                else -> {}
                            }
                        }
                    }
                }
            }
        }
    }
}

enum class Demo {
    HelloPlatform,
    Lorem,
    LazyColumn,
    Counter,
    Layout,
    TextStyles,
    Images,
    Buttons,
    TextFields,
    BottomNavigation,
}
