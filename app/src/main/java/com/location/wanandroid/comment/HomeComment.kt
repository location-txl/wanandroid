package com.location.wanandroid.comment

import com.location.wanandroid.module.ActivityModules
import com.location.wanandroid.module.HomeModule
import com.location.wanandroid.scops.HomeScop
import com.location.wanandroid.view.home.HomeActivity
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

//@HomeScop
//@Singleton
//@Component(modules = [HomeModule::class],dependencies = [AppComment::class])
@Component(modules = [HomeModule::class,ActivityModules::class])
interface HomeComment {
//    fun inject(homeActivity: HomeActivity)
}