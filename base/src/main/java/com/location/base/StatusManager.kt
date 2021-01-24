package com.location.base

object StatusManager {
    val loadingLiveData:ActiveLiveData<LoadingStatus> = ActiveLiveData()
}

enum class LoadingStatus{
    SHOW_LOADING,
    HIDE_LOADING,
    UNKNOW_NONE,

}