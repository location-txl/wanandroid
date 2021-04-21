package com.location.wanandroid.padingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.location.network.response.Result
import com.location.wanandroid.data.PublicList
import com.location.wanandroid.data.collect.CollectArticleItem
import com.location.wanandroid.repository.HomeRepository
import com.location.wanandroid.repository.UserRepository

/**
 *
 * @author tianxiaolong
 * time：2021/3/6 5:41 PM
 * description：
 */
class PublicArticleSource(private val id:Int,private val homeRepository: HomeRepository) :
    PagingSource<Int, PublicList>() {
    override fun getRefreshKey(state: PagingState<Int, PublicList>): Int? {
        return 0
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PublicList> {
        val loadIndex = params.key ?: 0
        return when (val response = homeRepository.publicList(id, loadIndex)) {
            is Result.Success -> LoadResult.Page(
                data = response.data.datas,
                prevKey = null,
                nextKey = loadIndex + 1
            )
            is Result.Fail -> LoadResult.Error(response.error)
        }

    }
}