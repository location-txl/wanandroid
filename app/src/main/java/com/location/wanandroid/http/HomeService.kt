package com.location.wanandroid.http

import com.location.wanandroid.data.HomeData
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
    @GET("article/list/{path}/json")
    suspend fun homeList(@Path("path") index:Int):WanResponse<HomeData>

    @GET("wenda/list/{path}/json")
    suspend fun qAList(@Path("path") index:Int):WanResponse<HomeData>



//    @GET("article/list/{path}/json")
//    suspend fun homeList(@Path("path") index:Int):WanResponse<HomeData>
}