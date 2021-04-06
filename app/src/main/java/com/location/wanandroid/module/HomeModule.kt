package com.location.wanandroid.module

import com.location.wanandroid.repository.RemoteHomeRep
import dagger.Module
import dagger.Provides

@Module
class HomeModule {
    @Provides
    fun homeRepProvides():RemoteHomeRep{
        return RemoteHomeRep()
    }
}