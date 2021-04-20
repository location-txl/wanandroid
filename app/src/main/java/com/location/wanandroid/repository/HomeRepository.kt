package com.location.wanandroid.repository

import com.location.base.BaseRepository
import com.location.network.response.Result
import com.location.wanandroid.data.HomeData
import com.location.wanandroid.data.PageData
import com.location.wanandroid.data.PublicArticle
import com.location.wanandroid.data.PublicList
import retrofit2.http.Path

/**
 *
 * @author tianxiaolong
 * time：2021/2/27 11:19 PM
 * description：
 */
interface HomeRepository : BaseRepository {
    suspend fun  loadHomeData(index:Int): Result<HomeData>

    suspend fun  loadQAData(index:Int): Result<HomeData>

    suspend fun public():Result<List<PublicArticle>>

    suspend fun publicList(id:Int, index: Int):Result<PageData<PublicList>>
}