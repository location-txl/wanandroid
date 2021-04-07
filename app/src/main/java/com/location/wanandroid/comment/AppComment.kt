package com.location.wanandroid.comment

import com.location.wanandroid.App
import com.location.wanandroid.module.ActivityModules
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton


/**
 *
 * @author tianxiaolong
 * time：2021/4/6 10:58 PM
 * description：
 */
//@HomeScops
@Singleton
@Component(modules = [AndroidInjectionModule::class,ActivityModules::class] /* ,dependencies = [HomeComment::class] */)
interface AppComment :AndroidInjector<App>{
    @Component.Factory
    abstract class Builder : AndroidInjector.Factory<App>


}