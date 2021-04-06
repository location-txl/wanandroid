package com.location.wanandroid

import android.app.Application
import android.content.Context
import com.location.network.RetrofitUtils
import com.location.wanandroid.comment.DaggerAppComment
import com.tencent.smtt.export.external.TbsCoreSettings
import com.tencent.smtt.sdk.QbSdk
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


/**
 *
 * @author tianxiaolong
 * time：2021/2/27 2:15 PM
 * description：
 */

lateinit var appContext: Context
    private set

class App : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        appContext = this
        RetrofitUtils.initContext(this)
        val map = HashMap<String, Any>()
        map[TbsCoreSettings.TBS_SETTINGS_USE_SPEEDY_CLASSLOADER] = true
        map[TbsCoreSettings.TBS_SETTINGS_USE_DEXLOADER_SERVICE] = true
        QbSdk.initTbsSettings(map)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
       return DaggerAppComment.factory().create(this)
    }
}