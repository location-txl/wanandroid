package com.location.wanandroid.viewmodels.home

import androidx.lifecycle.*
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.location.base.BaseViewModel
import com.location.network.parseResult
import com.location.wanandroid.data.PublicArticle
import com.location.wanandroid.padingsource.HomeSource
import com.location.wanandroid.padingsource.HomeSourceType
import com.location.wanandroid.repository.HomeRepository
import com.location.wanandroid.repository.UserRepository
import kotlinx.coroutines.async

/**
 *
 * @author tianxiaolong
 * time：2021/2/28 12:48 PM
 * description：
 */
class HomeViewModel(private val homeRep:HomeRepository,private val userRep:UserRepository): BaseViewModel() {

    val homeFlow = Pager(
        PagingConfig(pageSize = 20)
    ){
        HomeSource(homeRep,HomeSourceType.HOME_DATA)
    }.flow.cachedIn(viewModelScope)

    val qaFlow = Pager(
        PagingConfig(pageSize = 20)
    ){
        HomeSource(homeRep,HomeSourceType.QA_DATA)
    }.flow.cachedIn(viewModelScope)

    fun getpublic(): LiveData<List<PublicArticle>> {
        return liveData {

            homeRep.public().parseResult({
                emit(it)
            })
        }

    }


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

    class Factory(private val homeRep:HomeRepository,private val userRep:UserRepository): ViewModelProvider.Factory {


        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return HomeViewModel(homeRep, userRep) as T
        }
    }

}