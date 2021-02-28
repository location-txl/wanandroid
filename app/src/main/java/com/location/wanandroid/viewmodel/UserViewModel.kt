package com.location.wanandroid.viewmodel

import android.text.TextUtils
import androidx.databinding.ObservableField
import androidx.lifecycle.*
import com.location.base.BaseViewModel
import com.location.base.logDebug
import com.location.base.parseResult
import com.location.wanandroid.UserManager
import com.location.wanandroid.repository.RemoteUserRep
import com.location.wanandroid.repository.UserRepository
import kotlinx.coroutines.launch


class UserViewModel : BaseViewModel() {
    private val logRep: UserRepository by lazy { RemoteUserRep() }
    private val TAG = "UserViewModel"
    val userName :ObservableField<String> = ObservableField()
    val pwd :ObservableField<String> = ObservableField()
    private val _loginStateLiveData = MutableLiveData<LoginState>()

    fun loginStateLiveData():LiveData<LoginState>  = _loginStateLiveData


//    fun login(): LiveData<UserData> = liveData {
//        logDebug(TAG, "isMainThread  ${Looper.getMainLooper() == Looper.myLooper()}")
//        logDebug(TAG,"userName=${userName.get()?:"null"}")
//        val result = logRep.login("tianxiaolong", "tianxiaolong")
//
//        result.parseResult({
//            emit(it)
//        })
//
//
//    }

    fun login(){
        if(TextUtils.isEmpty(userName.get()) || TextUtils.isEmpty(pwd.get())){
            msgLiveData.value = "用户名或密码为null"
            return
        }
        logDebug(TAG, "userName=${userName.get()!!} pwd=${pwd.get()!!}")
        viewModelScope.launch {
            val result = logRep.login(userName.get()!!, pwd.get()!!)
            result.parseResult({
                UserManager.saveUserInfo(userName.get()!!,pwd.get()!!)
                _loginStateLiveData.value = LoginState.LOGIN
                logDebug(TAG,"login succful")
            },{_, msg ->
                msgLiveData.value = msg
            })
        }

    }

}

enum class LoginState{
    REGIST,
    LOGIN,
}


