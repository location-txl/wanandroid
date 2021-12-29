package com.location.wanandroid.viewmodels.collect

import androidx.lifecycle.*
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.filter
import com.location.base.BaseViewModel
import com.location.network.parseResult
import com.location.wanandroid.data.collect.CollectArticleItem
import com.location.wanandroid.data.collect.CollectWebSlite
import com.location.wanandroid.padingsource.CollectArticleSource
import com.location.wanandroid.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 *
 * @author tianxiaolong
 * time：2021/3/6 5:58 PM
 * description：
 */
class CollectViewModel(private val userRepository:UserRepository): BaseViewModel() {

    private val _removeItemFlow = MutableStateFlow(mutableListOf<CollectArticleItem>())
    private val removedItemsFlow: Flow<MutableList<CollectArticleItem>> get() = _removeItemFlow

    val coolectArticleFlow by lazy {
        Pager(config = PagingConfig(pageSize = 20)) {
            CollectArticleSource(userRepository)
        }.flow.cachedIn(viewModelScope).combine(removedItemsFlow) { pagingData, removed ->
            var filter = pagingData.filter {
                it !in removed
            }
           return@combine filter
        }
    }
    suspend fun removeRemoteData(item: CollectArticleItem):Boolean{
        return userRepository.unCollectArticleForCollectPage(item.id, item.originId).isSuccess()
    }

    fun removeLocalData(item: CollectArticleItem) {

        val removes = _removeItemFlow.value
        val list = mutableListOf(item)
        list.addAll(removes)
        _removeItemFlow.value = list

    }

    fun getWebSliteList():LiveData<List<CollectWebSlite>>{
        return liveData {
            userRepository.getCollectWebSliteList().parseResult({
                emit(it)
            })
        }
    }

    class Factory @Inject constructor(private val userRepository:UserRepository):ViewModelProvider.Factory{
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return CollectViewModel(userRepository) as T
        }

    }
}