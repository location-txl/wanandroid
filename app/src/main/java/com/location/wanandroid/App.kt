package com.location.wanandroid

import android.app.Application
import android.content.Context
import com.tencent.smtt.export.external.TbsCoreSettings
import com.tencent.smtt.sdk.QbSdk


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
        val map = HashMap<String, Any>()
        map[TbsCoreSettings.TBS_SETTINGS_USE_SPEEDY_CLASSLOADER] = true
        map[TbsCoreSettings.TBS_SETTINGS_USE_DEXLOADER_SERVICE] = true
        QbSdk.initTbsSettings(map)
    }
}