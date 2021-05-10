package com.location.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 *
 * @author tianxiaolong
 * time：2021/2/25 10:42 PM
 * description：
 */
open class BaseViewModel : ViewModel() {
    protected val msgLiveData:MutableLiveData<String>  = MutableLiveData<String>()
    fun msgLiveData():LiveData<String> = msgLiveData
}