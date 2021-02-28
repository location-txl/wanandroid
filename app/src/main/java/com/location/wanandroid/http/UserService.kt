package com.location.wanandroid.http

import com.location.base.EmptyData
import com.location.wanandroid.data.WanResponse
import com.location.wanandroid.data.UserData
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Path

interface UserService {
    @FormUrlEncoded
    @POST(LOGIN)
    suspend fun login(
        @Field("username") userName: String,
        @Field("password") pwd: String
    ): WanResponse<UserData>

    /**
     * 收藏站内文章 id为收藏的文章id
     * {
    "data": null,
    "errorCode": 0,
    "errorMsg": ""
    }
     */
    @POST("lg/collect/{collectId}/json")
    suspend fun collectArticle(@Path("collectId") id: Long): WanResponse<EmptyData>

    /**
     * 收藏站内文章 id为收藏的文章id
     * {
    "data": null,
    "errorCode": 0,
    "errorMsg": ""
    }
     */
    @POST("lg/uncollect_originId/{collectId}/json")
    suspend fun unCollectArticle(@Path("collectId") id: Long): WanResponse<EmptyData>

}