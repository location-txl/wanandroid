package com.location.wanandroid.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kotlinx.serialization.Serializable

@Serializable data object HomeRoute



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
