package com.location.wanandroid.comment

import android.content.Context
import com.location.wanandroid.App
import com.location.wanandroid.module.*
import com.location.wanandroid.viewmodels.collect.CollectViewModel
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


/**
 *
 * @author tianxiaolong
 * time：2021/4/6 10:58 PM
 * description：
 */
//@HomeScops
@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, ActivityModules::class, HomeModule::class, HttpModule::class, RepositoryModule::class])
interface AppComment :AndroidInjector<App>{
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComment
    }


}