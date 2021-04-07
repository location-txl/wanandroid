package com.location.wanandroid.module

import com.location.wanandroid.http.HomeService
import com.location.wanandroid.http.UserService
import com.location.wanandroid.repository.HomeRepository
import com.location.wanandroid.repository.RemoteHomeRep
import com.location.wanandroid.repository.RemoteUserRep
import com.location.wanandroid.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

/**
 *
 * @author tianxiaolong
 * time：2021/4/7 11:53 PM
 * description：
 *
 * kotlin 版本需要object类 并且 provider修饰的需要加jvmStatic注解
 */
@Module(includes = [RepositoryModule.Bindings::class,HttpModule::class])
object RepositoryModule {
    @Provides
    fun providesRemoteHomeRep(value: HomeService): RemoteHomeRep {
        return RemoteHomeRep(value)
    }

    @Provides
    fun providesRemoteUserRep(value: UserService): RemoteUserRep {
        return RemoteUserRep(value)
    }

    @Module
    interface Bindings {

        @Binds
        fun homeRep(value: RemoteHomeRep): HomeRepository

        @Binds
        fun userRep(value:RemoteUserRep): UserRepository
    }
}