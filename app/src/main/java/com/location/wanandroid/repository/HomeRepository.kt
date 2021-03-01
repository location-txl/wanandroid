package com.location.wanandroid.repository

import com.location.base.BaseRepository
import com.location.base.Result
import com.location.wanandroid.data.HomeData

/**
 *
 * @author tianxiaolong
 * time：2021/2/27 11:19 PM
 * description：
 */
interface HomeRepository : BaseRepository {
    suspend fun  loadHomeData(index:Int):Result<HomeData>
    suspend fun  loadQAData(index:Int):Result<HomeData>


}