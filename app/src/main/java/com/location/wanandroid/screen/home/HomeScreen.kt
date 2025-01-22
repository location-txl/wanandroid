package com.location.wanandroid.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.location.wanandroid.screen.DetailRoute
import kotlinx.serialization.Serializable

@Serializable data object HomeRoute

@Serializable data object HomeBase



fun NavGraphBuilder.homeScreen(goToDetail:(DetailRoute) -> Unit){
//    navigation<HomeRoute>(
//        startDestination = HomeRoute,
//        ){
//
//    }
    composable<HomeRoute>(){
        Column {
            Text("Home Route")
            Button(onClick = {
                goToDetail(DetailRoute("https://www.baidu.com"))
            }) {
                Text("Go to Detail")
            }
        }
    }
}
