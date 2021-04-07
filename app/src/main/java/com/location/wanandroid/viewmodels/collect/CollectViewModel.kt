package com.location.wanandroid.viewmodels.collect

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.location.base.BaseViewModel
import com.location.network.RetrofitUtils
import com.location.wanandroid.http.UserService
import com.location.wanandroid.padingsource.CollectArticleSource
import com.location.wanandroid.repository.RemoteUserRep
import com.location.wanandroid.repository.UserRepository
import javax.inject.Inject

/**
 *
 * @author tianxiaolong
 * time：2021/3/6 5:58 PM
 * description：
 */
class CollectViewModel(private val userRepository:UserRepository): BaseViewModel() {


    val coolectArticleFlow by lazy {
        Pager(config = PagingConfig(pageSize = 20)) {
            CollectArticleSource(userRepository)
        }.flow.cachedIn(viewModelScope)
    }

    class Factory @Inject constructor(private val userRepository:UserRepository):ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return CollectViewModel(userRepository) as T
        }

    }
}