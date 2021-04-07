package com.location.wanandroid.repository

import com.location.base.*
import com.location.network.call
import com.location.network.executeResponse
import com.location.network.response.Result
import com.location.network.safeCall
import com.location.wanandroid.data.CollectArticleData
import com.location.wanandroid.data.UserData
import com.location.wanandroid.http.UserService
import javax.inject.Inject

class RemoteUserRep @Inject constructor(): UserRepository {
    companion object{
        val instance:UserRepository by lazy { RemoteUserRep() }
    }
    private val service by lazy { com.location.network.RetrofitUtils.create(UserService::class.java) }

    override suspend fun login(username: String, pwd: String): Result<UserData> {
        return safeCall { executeResponse(service.login(username, pwd)) }
    }

    override suspend fun collectArticle(id: Long): Result<EmptyData> {
        return call { executeResponse(service.collectArticle(id)) }
    }
    override suspend fun unCollectArticle(id: Long): Result<EmptyData> {
        return call { executeResponse(service.unCollectArticle(id)) }
    }

    override suspend fun unLogout(): Result<EmptyData> {
        return call { executeResponse(service.unLogout()) }
    }

    override suspend fun getCollectList(index: Int): Result<CollectArticleData> {
        return safeCall { executeResponse(service.getCollectList(index)) }
    }


}