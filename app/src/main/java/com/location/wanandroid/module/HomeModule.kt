package com.location.wanandroid.module

import com.location.wanandroid.repository.HomeRepository
import com.location.wanandroid.repository.RemoteHomeRep
import com.location.wanandroid.repository.RemoteUserRep
import com.location.wanandroid.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 * kotlin 版本需要object类 并且 provider修饰的需要加jvmStatic注解
 */
@Module(includes = [HomeModule.Bindings::class])
object   HomeModule {

@Provides
@JvmStatic
fun remoteHomeRepProvides(): RemoteHomeRep {
    return RemoteHomeRep()
}
    @Module
    interface Bindings{
        @Binds
        fun hopmeRep(remoteHomeRepProvides: RemoteHomeRep): HomeRepository

        fun test()
    }

}