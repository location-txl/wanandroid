package com.location.wanandroid.repository

import com.location.network.executeResponse
import com.location.network.response.Result
import com.location.network.safeCall
import com.location.wanandroid.data.HomeData
import com.location.wanandroid.http.HomeService
import javax.inject.Inject
import javax.inject.Singleton

/**
 *
 * @author tianxiaolong
 * time：2021/2/27 11:25 PM
 * description：
 */

class RemoteHomeRep  :HomeRepository {
    companion object{
        val instacne : HomeRepository by lazy { RemoteHomeRep() }
    }
    private val service by lazy { com.location.network.RetrofitUtils.create(HomeService::class.java) }

    /**
     * 加载首页数据
     */
    override suspend fun loadHomeData(index: Int): Result<HomeData> {
       return safeCall { executeResponse(service.homeList(index)) }
    }

    /**
     *
     * @param index Int
     * @return Result<HomeData>
     */
    override suspend fun loadQAData(index: Int): Result<HomeData> {
        return safeCall { executeResponse(service.qAList(index)) }
    }
}