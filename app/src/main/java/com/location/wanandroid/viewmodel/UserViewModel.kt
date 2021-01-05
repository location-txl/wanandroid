package com.location.wanandroid.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.location.wanandroid.repository.RemoteUserRep
import com.location.wanandroid.repository.UserRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import okhttp3.Cookie
import java.util.concurrent.ConcurrentHashMap


class UserViewModel : ViewModel() {
    private val logRep:UserRepository by lazy { RemoteUserRep() }
    val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        Log.d("UserViewModel", "Caught original $exception")
    }
    fun login(){

        viewModelScope.launch {

                val userData = logRep.login("tianxiaolong","tianxiaolong")
                Log.d("UserViewModel",userData.toString())



        }

    }
}