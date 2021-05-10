package com.location.wanandroid.module

import com.location.wanandroid.data.DaggerData
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 *
 * @author tianxiaolong
 * time：4/27/21 11:30 PM
 * description：
 */
@Module
object TestModel {

    @Provides
    fun providerDaggerData():DaggerData{
        return DaggerData()
    }
}