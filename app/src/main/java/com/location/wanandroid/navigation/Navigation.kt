package com.location.wanandroid.navigation

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.material3.adaptive.WindowAdaptiveInfo
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteItemColors
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScope
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


@Composable
fun WanNavigationSuiteScaffold(
    modifier: Modifier = Modifier,
    windowAdaptiveInfo: WindowAdaptiveInfo = currentWindowAdaptiveInfo(),
    layoutType:NavigationSuiteType =  NavigationSuiteScaffoldDefaults
        .calculateFromAdaptiveInfo(windowAdaptiveInfo),
    navigation:  NavigationSuiteScope.() -> Unit,
    content: @Composable () -> Unit,
    ) {
    NavigationSuiteScaffold(
        navigationSuiteItems = navigation,
        layoutType = layoutType,
        containerColor = Color.Transparent,
        navigationSuiteColors = NavigationSuiteDefaults.colors(
            navigationBarContentColor = WanNavigationDefaults.navigationContentColor(),
            navigationRailContainerColor = Color.Transparent,
        ),
        modifier = modifier,
    ) {
        content()
    }

}


private object WanNavigationDefaults {
    @Composable
    fun navigationContentColor() = MaterialTheme.colorScheme.onSurfaceVariant

    @Composable
    fun navigationSelectedItemColor() = MaterialTheme.colorScheme.onPrimaryContainer

    @Composable
    fun navigationIndicatorColor() = MaterialTheme.colorScheme.primaryContainer
}


@Composable
fun getWanNavigationColors() = NavigationSuiteItemColors(
    navigationBarItemColors = NavigationBarItemDefaults.colors(
        selectedIconColor = WanNavigationDefaults.navigationSelectedItemColor(),
        unselectedIconColor = WanNavigationDefaults.navigationContentColor(),
        selectedTextColor = WanNavigationDefaults.navigationSelectedItemColor(),
        unselectedTextColor = WanNavigationDefaults.navigationContentColor(),
        indicatorColor = WanNavigationDefaults.navigationIndicatorColor(),
    ),
    navigationRailItemColors = NavigationRailItemDefaults.colors(
        selectedIconColor = WanNavigationDefaults.navigationSelectedItemColor(),
        unselectedIconColor = WanNavigationDefaults.navigationContentColor(),
        selectedTextColor = WanNavigationDefaults.navigationSelectedItemColor(),
        unselectedTextColor = WanNavigationDefaults.navigationContentColor(),
        indicatorColor = WanNavigationDefaults.navigationIndicatorColor(),
    ),
    navigationDrawerItemColors = NavigationDrawerItemDefaults.colors(
        selectedIconColor = WanNavigationDefaults.navigationSelectedItemColor(),
        unselectedIconColor = WanNavigationDefaults.navigationContentColor(),
        selectedTextColor = WanNavigationDefaults.navigationSelectedItemColor(),
        unselectedTextColor = WanNavigationDefaults.navigationContentColor(),
    ),
)