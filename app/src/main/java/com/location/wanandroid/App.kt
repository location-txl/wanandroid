package com.location.wanandroid

import android.app.Application
import android.content.Context

/**
 *
 * @author tianxiaolong
 * time：2021/2/27 2:15 PM
 * description：
 */
lateinit var  appContext:Context
private set
class App:Application() {

    override fun onCreate() {
        super.onCreate()
        appContext = this
    }
}