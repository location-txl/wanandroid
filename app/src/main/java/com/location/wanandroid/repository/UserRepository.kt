package com.location.wanandroid.repository

import com.location.base.BaseRepository
import com.location.network.response.Result
import com.location.base.EmptyData
import com.location.wanandroid.data.CollectArticleData
import com.location.wanandroid.data.UserData
import retrofit2.http.Path

interface UserRepository:BaseRepository {
    suspend fun login(username:String,pwd:String): Result<UserData>
    suspend fun collectArticle( id:Long): Result<EmptyData>
    suspend fun unCollectArticle( id:Long): Result<EmptyData>
    suspend fun unLogout(): Result<EmptyData>
    suspend fun getCollectList(@Path("path") index:Int): Result<CollectArticleData>
}