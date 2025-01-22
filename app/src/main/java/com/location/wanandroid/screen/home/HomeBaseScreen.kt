package com.location.wanandroid.screen.home

import android.app.ProgressDialog.show
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.WindowAdaptiveInfo
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.location.wanandroid.navigation.SettingRoute
import com.location.wanandroid.navigation.TopDestination
import com.location.wanandroid.navigation.WanNavigationSuiteScaffold
import com.location.wanandroid.navigation.getWanNavigationColors
import com.location.wanandroid.screen.DetailRoute

fun NavGraphBuilder.homeBaseScreen(
    paddingValue: PaddingValues, goToDetail: (DetailRoute) -> Unit
) {
    composable<HomeBase> {
        HomeBaseScreen(goToDetail = goToDetail)
    }
}


@Composable
private fun HomeBaseScreen(
    modifier: Modifier = Modifier,
    windowAdaptiveInfo: WindowAdaptiveInfo = currentWindowAdaptiveInfo(),
    goToDetail: (DetailRoute) -> Unit

) {
    Surface(modifier = modifier.fillMaxSize()) {
        var currentDirection by remember {
            mutableStateOf<TopDestination>(TopDestination.Home)
        }
        val navigationColors = getWanNavigationColors()
        val layoutType = NavigationSuiteScaffoldDefaults
            .calculateFromAdaptiveInfo(windowAdaptiveInfo)
        val navController = rememberNavController()

        WanNavigationSuiteScaffold(
            windowAdaptiveInfo = windowAdaptiveInfo,
            layoutType = layoutType,
            navigation = {
                    TopDestination.entries.forEach {
                        item(
                            selected = currentDirection == it,
                            onClick = {
                                navController.navigate(SettingRoute)
                                currentDirection = it
                                      },
                            icon = {
                                Icon(
                                    imageVector = if (currentDirection == it) it.selectIcon else it.unselectIcon,
                                    contentDescription = null
                                )
                            },
                            label = {
                                Text(stringResource(it.iconTextId))
                            },
                            colors = navigationColors,
                        )
                    }
            }
        ){
            Scaffold(
                modifier = modifier,)
            {
                Box(
                    Modifier
                        .fillMaxSize()
                        .padding(it)
                        .consumeWindowInsets(it)
                        .windowInsetsPadding(  // 只应用水平方向的安全区域 padding
                            WindowInsets.safeDrawing.only(
                                WindowInsetsSides.Horizontal,
                            )
                        ),
                ){
                    NavHost(
                        navController = navController,
                        startDestination = HomeRoute,

                        ){
                        homeScreen {
                            goToDetail(it)
                        }
                        composable<SettingRoute>{
                            Text("Setting Route")
                        }
                    }
                }
            }
        }
    }
}