package com.location.wanandroid.viewmodel

import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.location.base.BaseViewModel
import com.location.wanandroid.padingsource.HomeSource
import com.location.wanandroid.repository.RemoteHomeRep

/**
 *
 * @author tianxiaolong
 * time：2021/2/28 12:48 PM
 * description：
 */
class HomeViewModel: BaseViewModel() {
    val homeRep  by lazy { RemoteHomeRep() }
    val homeFlow = Pager(
        PagingConfig(pageSize = 20)
    ){
        HomeSource(homeRep)
    }.flow.cachedIn(viewModelScope)


}