package com.location.wanandroid.repository

import com.location.base.*
import com.location.wanandroid.RetrofitUtils
import com.location.wanandroid.data.CollectArticleData
import com.location.wanandroid.data.UserData
import com.location.wanandroid.http.UserService

class RemoteUserRep : UserRepository {
    private val service by lazy { RetrofitUtils.create(UserService::class.java) }

    override suspend fun login(username: String, pwd: String): Result<UserData> {
        return safeCall { excutResponse(service.login(username, pwd)) }
    }

    override suspend fun collectArticle(id: Long): Result<EmptyData> {
        return call { excutResponse(service.collectArticle(id)) }
    }
    override suspend fun unCollectArticle(id: Long): Result<EmptyData> {
        return call { excutResponse(service.unCollectArticle(id)) }
    }

    override suspend fun unLogout(): Result<EmptyData> {
        return call { excutResponse(service.unLogout()) }
    }

    override suspend fun getCollectList(index: Int): Result<CollectArticleData> {
        return safeCall { excutResponse(service.getCollectList(index)) }
    }


}