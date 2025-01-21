package com.location.wanandroid

import android.R.attr.text
import android.app.ProgressDialog.show
import android.util.Log.v
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.material3.Scaffold
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
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.location.wanandroid.navigation.WanNavigationSuiteScaffold
import com.location.wanandroid.navigation.getWanNavigationColors
import com.location.wanandroid.screen.DetailRoute
import com.location.wanandroid.screen.HomeRoute
import com.location.wanandroid.screen.detailScreenScreen
import com.location.wanandroid.screen.homeScreen

@Composable
fun WanAndroidApp(
    modifier: Modifier = Modifier,
    windowAdaptiveInfo: WindowAdaptiveInfo = currentWindowAdaptiveInfo(),
) {
    Surface(modifier = modifier.fillMaxSize()) {
        var currentDirection by remember {
            mutableStateOf<TopDestination>(TopDestination.Home)
        }
        val navigationColors = getWanNavigationColors()
        var show by remember { mutableStateOf(true) }
        val originType = NavigationSuiteScaffoldDefaults
            .calculateFromAdaptiveInfo(windowAdaptiveInfo)
        val layoutType by remember {
            derivedStateOf {
                if(show){
                    originType
                }else{
                    NavigationSuiteType.None
                }
            }
        }
        WanNavigationSuiteScaffold(
            windowAdaptiveInfo = windowAdaptiveInfo,
            layoutType = layoutType,
            navigation = {
                if(show){
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
                            colors = navigationColors,
                        )
                    }
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
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = HomeRoute,

                    ){
                        homeScreen{
                            show = false
                            navController.navigate(it)
                        }
                        detailScreenScreen()
                    }
                }
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

