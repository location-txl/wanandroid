package com.location.wanandroid

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.adaptive.WindowAdaptiveInfo
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.location.wanandroid.navigation.TopDestination
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.location.wanandroid.navigation.getWanNavigationColors
import com.location.wanandroid.screen.detailScreenScreen
import com.location.wanandroid.screen.home.HomeBase
import com.location.wanandroid.screen.home.homeBaseScreen


@Composable
fun WanAndroidTest(modifier: Modifier = Modifier,
                   windowAdaptiveInfo: WindowAdaptiveInfo = currentWindowAdaptiveInfo(),

                   ) {
    Surface(modifier = modifier.fillMaxSize()) {
        var currentDirection by remember {
            mutableStateOf<TopDestination>(TopDestination.Home)
        }
        val navigationColors = getWanNavigationColors()
        var show by remember { mutableStateOf(true) }
        val originType =
            NavigationSuiteScaffoldDefaults.calculateFromAdaptiveInfo(windowAdaptiveInfo)
        val layoutType by remember {
            derivedStateOf {
                if (show) {
                    originType
                } else {
                    NavigationSuiteType.None
                }
            }
        }
        Scaffold { paddingValue ->
            Box(
            ) {
                val navController = rememberNavController()

                NavHost(
                    startDestination = HomeBase,
                    navController = navController,
                ) {
                    homeBaseScreen(paddingValue){
                        navController.navigate(it)
                    }
                    detailScreenScreen(paddingValue)
                }
            }
        }


    }
}


@Preview(device = "spec:parent=Nexus S")
@Composable
private fun WanAndroidAppPreview() {
    MaterialTheme {
    }
}

