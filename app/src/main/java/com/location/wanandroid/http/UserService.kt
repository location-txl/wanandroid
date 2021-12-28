package com.location.wanandroid.http

import com.location.base.EmptyData
import com.location.wanandroid.data.UserData
import com.location.wanandroid.data.collect.WanCollectArticle
import com.location.wanandroid.data.WanResponse
import com.location.wanandroid.data.collect.CollectArticleItem
import com.location.wanandroid.data.collect.CollectWebSliteData
import retrofit2.http.*

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
     * 取消收藏站内文章 id为收藏的文章id 文章列表页
     * {
    "data": null,
    "errorCode": 0,
    "errorMsg": ""
    }
     */
    @POST("lg/uncollect_originId/{collectId}/json")
    suspend fun unCollectArticle(@Path("collectId") id: Long): WanResponse<EmptyData>


    /**
     * 退出登陆
     *
     */
    @GET("user/logout/json")
    suspend fun unLogout(): WanResponse<EmptyData>


    /**
     *获取收藏文章列表
     */
    @GET("lg/collect/list/{path}/json")
    suspend fun getCollectList(@Path("path") index: Int): WanCollectArticle

    /**
     * 获取收藏的网站列表
     *  {
    "desc": "",
    "icon": "",
    "id": 650,
    "link": "http://www.baidu.com",
    "name": "玩Android",
    "order": 0,
    "userId": 428,
    "visible": 1
    }
     * @return CollectWebSliteData
     */
    @GET("lg/collect/usertools/json")
    suspend fun getWebSliteList(): CollectWebSliteData

    /**
     * 取消收藏 在收藏列表页
     * @param id Int
     * @param originId Int
     * @return WanResponse<EmptyData>
     * @see CollectArticleItem
     */
    @FormUrlEncoded
    @POST("lg/uncollect/{id}/json")
    suspend fun unCollectArticleForCollectPage(
        @Path("id") id: Int,
        @Field("originId") originId: Int
    ): WanResponse<EmptyData>


}