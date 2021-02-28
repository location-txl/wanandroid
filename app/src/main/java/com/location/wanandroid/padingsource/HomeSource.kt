package com.location.wanandroid.padingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.location.base.Result
import com.location.base.logDebug
import com.location.wanandroid.data.HomeListData
import com.location.wanandroid.repository.HomeRepository
import kotlin.random.Random

/**
 *
 * @author tianxiaolong
 * time：2021/2/27 11:10 PM
 * description：
 */
class HomeSource(val homeRep: HomeRepository): PagingSource<Int, HomeListData>() {
    private val TAG = "HomeSource"
    override fun getRefreshKey(state: PagingState<Int, HomeListData>): Int? {
        logDebug(TAG,"getRefreshKey")
        return 0
    }

    /**
     * paging3加载数据
     */
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, HomeListData> {
        // 获取加载的索引 没有就从0开始
        val loadIndex = params.key?:0

        logDebug(TAG,"load loadIndex=$loadIndex")
        return when(val response = homeRep.loadHomeData(loadIndex)){
            is Result.Success -> LoadResult.Page(
                data = response.data.datas,
                prevKey = null,
                nextKey = loadIndex+1
            )
            is Result.Fail -> LoadResult.Error(response.error)
        }
//       response.parseResult({
//           return LoadResult.Page(
//               data = it.datas,
//               prevKey = loadIndex,
//              nextKey = loadIndex+1
//           )
//       },{_,msg->
//           return@parseResult LoadResult.Error<Int, HomeListData>(IOException())
//       })
    }
}