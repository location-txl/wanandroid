package com.location.wanandroid.comment

import com.location.wanandroid.module.HomeModule
import com.location.wanandroid.view.home.HomeActivity
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Component(modules = [HomeModule::class, AndroidInjectionModule::class])
interface HomeComment {
//    fun inject(homeActivity: HomeActivity)
}