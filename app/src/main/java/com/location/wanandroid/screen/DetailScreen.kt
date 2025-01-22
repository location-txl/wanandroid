package com.location.wanandroid.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.location.wanandroid.network.WanAndroidApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel
import org.koin.androidx.compose.navigation.koinNavViewModel
import org.koin.compose.koinInject
import org.koin.core.KoinApplication.Companion.init
import org.koin.core.parameter.parametersOf
import org.koin.java.KoinJavaComponent.inject
import kotlin.time.Duration.Companion.seconds

@Serializable data class DetailRoute(val url: String)


fun NavGraphBuilder.detailScreenScreen(paddingValues: PaddingValues, ) {
    composable<DetailRoute>{
        val route = it.toRoute<DetailRoute>()
        val detailViewModel: DetailViewModel = koinViewModel{
            parametersOf(route)
        }
        val count = detailViewModel.countFlow.collectAsStateWithLifecycle(0)

        Column(modifier = Modifier.padding(paddingValues)){

            Text("Detail Route url: ${detailViewModel.convertUrl(route.url)}")
            HorizontalDivider()
            Text("Count: ${count.value}")
//            TextAlign(v = count.value)
        }
    }
}

@Composable
fun TextAlign(modifier: Modifier = Modifier, v: Int) {
    Text("Count: ${v}")

}



class DetailViewModel(val api: WanAndroidApi, route: DetailRoute): ViewModel(){
    init {
        println("init DetailViewModel api: $api route: $route")
        viewModelScope
    }
    val countFlow: StateFlow<Int> = flow {
        var c = 0
        println("start collect")
        while (true) {
            emit(c++)
            delay(1.seconds)
            println("$c ++")
        }
    }.stateIn(viewModelScope, started = SharingStarted.WhileSubscribed(5000L), 0)

    fun convertUrl(url: String) = "url:$url"

    override fun onCleared() {
        super.onCleared()
        println("onCleared")

    }
}


