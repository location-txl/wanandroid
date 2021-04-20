package com.location.wanandroid.repository

import com.location.network.executeResponse
import com.location.network.response.Result
import com.location.network.safeCall
import com.location.wanandroid.data.HomeData
import com.location.wanandroid.data.PageData
import com.location.wanandroid.data.PublicArticle
import com.location.wanandroid.data.PublicList
import com.location.wanandroid.http.HomeService

/**
 *
 * @author tianxiaolong
 * time：2021/2/27 11:25 PM
 * description：
 */

class RemoteHomeRep(private val service: HomeService) : HomeRepository {


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

    override suspend fun public(): Result<List<PublicArticle>> {
        return safeCall { executeResponse(service.public()) }
    }

    override suspend fun publicList(id: Int, index: Int): Result<PageData<PublicList>> {
        return safeCall { executeResponse(service.publicList(id, index)) }
    }
}