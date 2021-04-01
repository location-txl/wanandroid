package com.location.wanandroid.viewmodels.collect

import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.location.base.BaseViewModel
import com.location.wanandroid.padingsource.CollectArticleSource
import com.location.wanandroid.repository.RemoteUserRep

/**
 *
 * @author tianxiaolong
 * time：2021/3/6 5:58 PM
 * description：
 */
class CollectViewModel: BaseViewModel() {
    private val userRepository by lazy { RemoteUserRep() }


    val coolectArticleFlow by lazy {
        Pager(config = PagingConfig(pageSize = 20)) {
            CollectArticleSource(userRepository)
        }.flow.cachedIn(viewModelScope)
    }
}