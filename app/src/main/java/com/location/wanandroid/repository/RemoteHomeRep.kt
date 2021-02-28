package com.location.wanandroid.repository

import com.location.base.Result
import com.location.base.excutResponse
import com.location.base.safeCall
import com.location.wanandroid.RetrofitUtils
import com.location.wanandroid.data.HomeData
import com.location.wanandroid.http.HomeService

/**
 *
 * @author tianxiaolong
 * time：2021/2/27 11:25 PM
 * description：
 */
class RemoteHomeRep:HomeRepository {
    private val service by lazy { RetrofitUtils.create(HomeService::class.java) }
    override suspend fun loadHomeData(index: Int): Result<HomeData> {
       return safeCall { excutResponse(service.homeList(index)) }
    }
}