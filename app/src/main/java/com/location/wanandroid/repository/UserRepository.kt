package com.location.wanandroid.repository

import com.location.base.BaseRepository
import com.location.base.Result
import com.location.base.EmptyData
import com.location.wanandroid.data.UserData

interface UserRepository:BaseRepository {
    suspend fun login(username:String,pwd:String): Result<UserData>
    suspend fun collectArticle( id:Long): Result<EmptyData>
    suspend fun unCollectArticle( id:Long): Result<EmptyData>
}