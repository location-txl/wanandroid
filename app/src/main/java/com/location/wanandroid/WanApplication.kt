package com.location.wanandroid

import android.app.Application
import androidx.activity.ComponentActivity
import com.location.wanandroid.network.httpModules
import com.location.wanandroid.screen.DetailViewModel
import okhttp3.internal.tls.OkHostnameVerifier.verify
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.core.module.dsl.viewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import java.util.logging.Logger

class WanApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            printLogger(Level.DEBUG)
            androidContext(this@WanApplication)
            modules(module{
                scope<ComponentActivity> {
                    scoped{
                        UserViewModel()
                    }
                }
                viewModelOf(::DetailViewModel)
            }, httpModules)

        }
    }
}