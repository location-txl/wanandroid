package com.location.wanandroid.http

import com.location.wanandroid.data.HomeData
import com.location.wanandroid.data.PublicArticleData
import com.location.wanandroid.data.PublicListData
import com.location.wanandroid.data.WanResponse
import retrofit2.http.GET
import retrofit2.http.Path

/**
 *
 * @author tianxiaolong
 * time：2021/2/27 11:21 PM
 * description：
 */
interface HomeService {
    /**
     * 获取首页文章列表
     * @param index Int
     * @return WanResponse<HomeData>
     */
    @GET("article/list/{path}/json")
    suspend fun homeList(@Path("path") index:Int):WanResponse<HomeData>

    /**
     * 获取问答
     * @param index Int
     * @return WanResponse<HomeData>
     */
    @GET("wenda/list/{path}/json")
    suspend fun qAList(@Path("path") index:Int):WanResponse<HomeData>

    /**
     * 获取公众号列表
     */
    @GET("wxarticle/chapters/json")
    suspend fun public():PublicArticleData

    /**
     * 获取公告号作者历史记录
     * @param id 公众号作者id
     * @param index 页码
     */
    @GET("wxarticle/list/{id}/{index}/json")
    suspend fun publicList(@Path("id") id:Int,@Path("index") index: Int):PublicListData


}