package com.rouge41.kmm.compose.navigation

import com.rouge41.kmm.compose.runtime.Composable

expect class Bundle {
    fun get(p0: String): Any?
}
expect class NavHostController {
    fun popBackStack(): Boolean
}
expect class NavGraphBuilder
expect class NavBackStackEntry {
    val arguments: Bundle?
}
expect class NavDeepLink
expect class NamedNavArgument
expect class NavController
expect class NavOptionsBuilder

@Composable
expect fun rememberNavController(): NavHostController

@Composable
expect fun NavHost(
        navController: NavHostController,
        startDestination: String,
        route: String? = null,
        builder: NavGraphBuilder.() -> Unit
)

expect fun NavGraphBuilder.composable(
        route: String,
        title: String? = null,
        leadingButton: @Composable (() -> Unit)? = null,
        trailingButton: @Composable (() -> Unit)? = null,
        arguments: List<NamedNavArgument> = emptyList(),
        deepLinks: List<NavDeepLink> = emptyList(),
        content: @Composable (NavBackStackEntry) -> Unit
)

expect fun NavController.navigate(route: String, builder: NavOptionsBuilder.() -> Unit = {})