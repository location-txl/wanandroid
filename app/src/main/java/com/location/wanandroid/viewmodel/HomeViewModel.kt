package com.location.wanandroid.viewmodel

import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.location.base.BaseViewModel
import com.location.wanandroid.padingsource.HomeSource
import com.location.wanandroid.repository.RemoteHomeRep
import com.location.wanandroid.repository.RemoteUserRep
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

/**
 *
 * @author tianxiaolong
 * time：2021/2/28 12:48 PM
 * description：
 */
class HomeViewModel: BaseViewModel() {
    val homeRep  by lazy { RemoteHomeRep() }
    val userRep  by lazy { RemoteUserRep() }
    val homeFlow = Pager(
        PagingConfig(pageSize = 20)
    ){
        HomeSource(homeRep)
    }.flow.cachedIn(viewModelScope)


    suspend fun collect(id:Long,collect:Boolean): Boolean {
        val async = viewModelScope.async {
            val collectArticle = if(collect)
                userRep.collectArticle(id)
            else
                userRep.unCollectArticle(id)
            collectArticle.isSuccess()
        }

        return async.await()
    }


}