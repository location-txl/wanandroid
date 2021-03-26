package com.location.wanandroid.padingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.location.network.response.Result
import com.location.wanandroid.data.CollectArticleItem
import com.location.wanandroid.repository.UserRepository

/**
 *
 * @author tianxiaolong
 * time：2021/3/6 5:41 PM
 * description：
 */
class CollectArticleSource(private val userRepository: UserRepository) :
    PagingSource<Int, CollectArticleItem>() {
    override fun getRefreshKey(state: PagingState<Int, CollectArticleItem>): Int? {
        return 0
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CollectArticleItem> {
        val loadIndex = params.key ?: 0
        return when (val response = userRepository.getCollectList(loadIndex)) {
            is Result.Success -> LoadResult.Page(
                data = response.data.datas,
                prevKey = null,
                nextKey = loadIndex + 1
            )
            is Result.Fail -> LoadResult.Error(response.error)
        }

    }
}