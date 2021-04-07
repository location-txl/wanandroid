package com.location.wanandroid.module

import com.location.wanandroid.MainActivity
import com.location.wanandroid.scops.HomeScops
import com.location.wanandroid.view.DetailsActivity
import com.location.wanandroid.view.collect.CollectActivity
import com.location.wanandroid.view.collect.CollectArticleFragment
import com.location.wanandroid.view.home.HomeActivity
import com.location.wanandroid.view.home.HomeFragment
import com.location.wanandroid.view.home.MeSettingFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 *
 * @author tianxiaolong
 * time：2021/4/6 11:02 PM
 * description：
 */

@Module(includes = [HomeModule::class])
abstract class ActivityModules {

    @ContributesAndroidInjector(modules = [HomeModule::class])
    abstract fun injectHomeActivity():HomeActivity

    @ContributesAndroidInjector
    abstract fun injectCollectActivity():CollectActivity

    @ContributesAndroidInjector
    abstract fun injectMainActivity():MainActivity

    @ContributesAndroidInjector
    abstract fun injectHomeFragment():HomeFragment

    @ContributesAndroidInjector
    abstract fun injectCollectArticleFragment():CollectArticleFragment



    @ContributesAndroidInjector
    abstract fun injectMeSeettingsFragment():MeSettingFragment
}