package com.location.wanandroid.repository

import com.location.wanandroid.data.UserData
import kotlinx.coroutines.Deferred

interface UserRepository {
    suspend fun login(username:String,pwd:String): UserData
}