package com.location.wanandroid

import android.R.attr.top
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.location.wanandroid.network.WanAndroidApi
import com.location.wanandroid.network.execute
import com.location.wanandroid.ui.theme.WanAndroidTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.android.scope.AndroidScopeComponent
import org.koin.androidx.scope.activityScope
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.compose.KoinContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.scope.Scope

object TestVm: KoinComponent{
//    val vm: UserViewModel = get()
}

class MainActivity : ComponentActivity()  {
    private val wanAndroidApi: WanAndroidApi by inject()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        lifecycleScope.launch{
            enableEdgeToEdge(

                )
//            navigationBarStyle = SystemBarStyle.auto(
//                lightScrim = lightScrim,
//                darkScrim = darkScrim,
//            ) {
//                false
//            }
        }

        lifecycleScope.launch(Dispatchers.IO){
//            val r = wanAndroidApi.execute {
//                getArticleList(0)
//            }
//            Log.i("MainActivity", "onCreate: $r")
        }
        setContent {
            KoinContext {
                WanAndroidTheme(dynamicColor = false) {
                    WanAndroidTest(
                    )
                }
            }

        }
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WanAndroidTheme {
        Greeting("Android")
    }
}


private val lightScrim = android.graphics.Color.argb(0xe6, 0xFF, 0xFF, 0xFF)
private val darkScrim = android.graphics.Color.argb(0x80, 0x1b, 0x1b, 0x1b)


