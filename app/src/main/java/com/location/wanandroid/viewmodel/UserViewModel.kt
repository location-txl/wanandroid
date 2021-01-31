package com.location.wanandroid.viewmodel

import android.os.Looper
import android.util.Log
import androidx.lifecycle.*
import com.location.base.Result
import com.location.base.logDebug
import com.location.wanandroid.data.UserData
import com.location.wanandroid.repository.RemoteUserRep
import com.location.wanandroid.repository.UserRepository


class UserViewModel : ViewModel() {
    private val logRep: UserRepository by lazy { RemoteUserRep() }
    private val TAG = "UserViewModel"


    fun login(): LiveData<UserData> = liveData {


        logDebug(TAG, "isMainThread  ${Looper.getMainLooper() == Looper.myLooper()}")
        val result = logRep.login("tianxiaolong", "tianxiaolong")
        if (result is Result.Success) {
            Log.d("UserViewModel", result.data.toString())
            emit(result.data)
        }


    }


}


