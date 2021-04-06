package com.location.wanandroid.comment

import com.location.wanandroid.module.HomeModule
import com.location.wanandroid.view.home.HomeActivity
import dagger.Component

@Component(modules = [HomeModule::class])
interface HomeComment {
    fun inject(homeActivity: HomeActivity)
}