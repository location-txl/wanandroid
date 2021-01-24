package com.location.wanandroid.repository

import com.location.wanandroid.data.UserData

interface UserRepository {
    suspend fun login(username:String,pwd:String): UserData
}