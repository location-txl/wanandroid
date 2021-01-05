package com.location.wanandroid.repository

import com.location.wanandroid.RetrofitUtils
import com.location.wanandroid.data.UserData
import com.location.wanandroid.http.LoginService
import kotlinx.coroutines.Deferred

class RemoteUserRep:UserRepository {
    private  val service by lazy { RetrofitUtils.create(LoginService::class.java)}

    override suspend fun login(username: String, pwd: String): UserData {
        return  service.login(username,pwd)
    }
}