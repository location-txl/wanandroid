package com.location.wanandroid.http

import com.location.wanandroid.data.UserData
import kotlinx.coroutines.Deferred
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Multipart
import retrofit2.http.POST

interface LoginService {
    @FormUrlEncoded
    @POST(LOGIN)
    suspend fun login(@Field("username") userName:String, @Field("password") pwd:String): UserData

}