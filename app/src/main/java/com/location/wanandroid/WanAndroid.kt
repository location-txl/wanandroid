package com.location.wanandroid

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.WindowAdaptiveInfo
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.adaptive.navigation.ThreePaneScaffoldNavigator
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuite
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteItemColors
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.location.wanandroid.navigation.TopDestination
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource

@Composable
fun WanAndroidApp(
    modifier: Modifier = Modifier,
    windowAdaptiveInfo: WindowAdaptiveInfo = currentWindowAdaptiveInfo(),
) {
    Surface(modifier = modifier.fillMaxSize()) {
        val layoutType =
            NavigationSuiteScaffoldDefaults.calculateFromAdaptiveInfo(windowAdaptiveInfo)
        var currentDirection by remember {
            mutableStateOf<TopDestination>(TopDestination.Home)
        }
        val navigationSuiteItemColors = NavigationSuiteItemColors(
            navigationBarItemColors = NavigationBarItemDefaults.colors(
                selectedIconColor = NiaNavigationDefaults.navigationSelectedItemColor(),
                unselectedIconColor = NiaNavigationDefaults.navigationContentColor(),
                selectedTextColor = NiaNavigationDefaults.navigationSelectedItemColor(),
                unselectedTextColor = NiaNavigationDefaults.navigationContentColor(),
                indicatorColor = NiaNavigationDefaults.navigationIndicatorColor(),
            ),
            navigationRailItemColors = NavigationRailItemDefaults.colors(
                selectedIconColor = NiaNavigationDefaults.navigationSelectedItemColor(),
                unselectedIconColor = NiaNavigationDefaults.navigationContentColor(),
                selectedTextColor = NiaNavigationDefaults.navigationSelectedItemColor(),
                unselectedTextColor = NiaNavigationDefaults.navigationContentColor(),
                indicatorColor = NiaNavigationDefaults.navigationIndicatorColor(),
            ),
            navigationDrawerItemColors = NavigationDrawerItemDefaults.colors(
                selectedIconColor = NiaNavigationDefaults.navigationSelectedItemColor(),
                unselectedIconColor = NiaNavigationDefaults.navigationContentColor(),
                selectedTextColor = NiaNavigationDefaults.navigationSelectedItemColor(),
                unselectedTextColor = NiaNavigationDefaults.navigationContentColor(),
            ),
        )
        NavigationSuiteScaffold(
            layoutType = layoutType,
            containerColor = Color.Transparent,
            navigationSuiteColors = NavigationSuiteDefaults.colors(
                navigationBarContentColor = NiaNavigationDefaults.navigationContentColor(),
                navigationRailContainerColor = Color.Transparent,
            ),
            navigationSuiteItems = {
                TopDestination.entries.forEach {
                    item(
                        selected = currentDirection == it,
                        onClick = { currentDirection = it },
                        icon = {
                            Icon(
                                imageVector = if (currentDirection == it) it.selectIcon else it.unselectIcon,
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(stringResource(it.iconTextId))
                        },
                        colors = navigationSuiteItemColors,
                    )
                }
            }
        ) {
            Text("hello")
        }
    }
}


@Composable
private fun TestNavigationSuite(
    modifier: Modifier = Modifier,
    windowAdaptiveInfo: WindowAdaptiveInfo = currentWindowAdaptiveInfo(),
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        val layoutType =
            NavigationSuiteScaffoldDefaults.calculateFromAdaptiveInfo(windowAdaptiveInfo)
        var currentDirection by remember {
            mutableStateOf<TopDestination>(TopDestination.Home)
        }
        val navigationSuiteItemColors = NavigationSuiteItemColors(
            navigationBarItemColors = NavigationBarItemDefaults.colors(
                selectedIconColor = NiaNavigationDefaults.navigationSelectedItemColor(),
                unselectedIconColor = NiaNavigationDefaults.navigationContentColor(),
                selectedTextColor = NiaNavigationDefaults.navigationSelectedItemColor(),
                unselectedTextColor = NiaNavigationDefaults.navigationContentColor(),
                indicatorColor = NiaNavigationDefaults.navigationIndicatorColor(),
            ),
            navigationRailItemColors = NavigationRailItemDefaults.colors(
                selectedIconColor = NiaNavigationDefaults.navigationSelectedItemColor(),
                unselectedIconColor = NiaNavigationDefaults.navigationContentColor(),
                selectedTextColor = NiaNavigationDefaults.navigationSelectedItemColor(),
                unselectedTextColor = NiaNavigationDefaults.navigationContentColor(),
                indicatorColor = NiaNavigationDefaults.navigationIndicatorColor(),
            ),
            navigationDrawerItemColors = NavigationDrawerItemDefaults.colors(
                selectedIconColor = NiaNavigationDefaults.navigationSelectedItemColor(),
                unselectedIconColor = NiaNavigationDefaults.navigationContentColor(),
                selectedTextColor = NiaNavigationDefaults.navigationSelectedItemColor(),
                unselectedTextColor = NiaNavigationDefaults.navigationContentColor(),
            ),
        )
        NavigationSuite(
            layoutType = layoutType,
        ) {
            TopDestination.entries.forEach {
                item(
                    selected = currentDirection == it,
                    onClick = { currentDirection = it },
                    icon = {
                        Icon(
                            imageVector = if (currentDirection == it) it.selectIcon else it.unselectIcon,
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(stringResource(it.iconTextId))
                    },
                    colors = navigationSuiteItemColors,
                )
            }

        }
    }
}


@Preview(device = "spec:parent=Nexus S")
@Composable
private fun WanAndroidAppPreview() {
    MaterialTheme {
        WanAndroidApp()
    }


}

object NiaNavigationDefaults {
    @Composable
    fun navigationContentColor() = MaterialTheme.colorScheme.onSurfaceVariant

    @Composable
    fun navigationSelectedItemColor() = MaterialTheme.colorScheme.onPrimaryContainer

    @Composable
    fun navigationIndicatorColor() = MaterialTheme.colorScheme.primaryContainer
}