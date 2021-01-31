package com.location.wanandroid.repository

import com.location.base.BaseRepository
import com.location.base.Result
import com.location.wanandroid.data.UserData

interface UserRepository:BaseRepository {
    suspend fun login(username:String,pwd:String): Result<UserData>
}