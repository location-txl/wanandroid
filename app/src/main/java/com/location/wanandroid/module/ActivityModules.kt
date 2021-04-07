package com.location.wanandroid.module

import com.location.wanandroid.scops.HomeScop
import com.location.wanandroid.view.home.HomeActivity
import com.location.wanandroid.view.home.HomeFragment
import com.location.wanandroid.view.home.MeSettingFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

/**
 *
 * @author tianxiaolong
 * time：2021/4/6 11:02 PM
 * description：
 */

@Module
abstract class ActivityModules {

//    @HomeScop
    @ContributesAndroidInjector(modules = [HomeModule::class])
    abstract fun injectHomeActivity():HomeActivity

//    @HomeScop
    @ContributesAndroidInjector(modules = [HomeModule::class])
    abstract fun injectHomeFragment():HomeFragment

    @ContributesAndroidInjector
    abstract fun injectMeSeettingsFragment():MeSettingFragment
}