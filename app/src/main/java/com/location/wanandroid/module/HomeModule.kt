package com.location.wanandroid.module

import com.location.network.RetrofitUtils
import com.location.wanandroid.http.HomeService
import com.location.wanandroid.http.UserService
import com.location.wanandroid.repository.HomeRepository
import com.location.wanandroid.repository.RemoteHomeRep
import com.location.wanandroid.repository.RemoteUserRep
import com.location.wanandroid.repository.UserRepository
import com.location.wanandroid.viewmodels.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides

/**
 * kotlin 版本需要object类 并且 provider修饰的需要加jvmStatic注解
 */
@Module(includes = [RepositoryModule::class])
object HomeModule {


    @Provides
    fun providesHomeViewModelFactory(
        homeRep: HomeRepository,
        userRep: UserRepository
    ): HomeViewModel.Factory {
        return HomeViewModel.Factory(homeRep, userRep)
    }


}