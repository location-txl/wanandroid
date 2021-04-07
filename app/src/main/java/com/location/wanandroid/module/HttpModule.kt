package com.location.wanandroid.module

import com.location.network.RetrofitUtils
import com.location.wanandroid.http.HomeService
import com.location.wanandroid.http.UserService
import dagger.Module
import dagger.Provides

/**
 *
 * @author tianxiaolong
 * time：2021/4/7 11:46 PM
 * description：
 */
@Module
object HttpModule {
    @Provides
    fun providesHomeService(): HomeService {
        return RetrofitUtils.create(HomeService::class.java)
    }

    @Provides
    fun providesUserService(): UserService {
        return RetrofitUtils.create(UserService::class.java)
    }
}