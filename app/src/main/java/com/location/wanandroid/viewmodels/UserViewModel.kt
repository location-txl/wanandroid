package com.location.wanandroid.viewmodels

import android.text.TextUtils
import androidx.databinding.ObservableField
import androidx.lifecycle.*
import com.location.base.*
import com.location.network.RetrofitUtils
import com.location.network.parseResult
import com.location.network.response.Result
import com.location.wanandroid.UserManager
import com.location.wanandroid.http.UserService
import com.location.wanandroid.repository.RemoteUserRep
import com.location.wanandroid.repository.UserRepository
import kotlinx.coroutines.*
import javax.inject.Inject


class UserViewModel(private val logRep: UserRepository) : BaseViewModel() {
    private val TAG = "UserViewModel"
    val userName :ObservableField<String> = ObservableField()
    val pwd :ObservableField<String> = ObservableField()
    private val _loginStateLiveData = MutableLiveData<LoginState>()

    fun loginStateLiveData():LiveData<LoginState>  = _loginStateLiveData



    fun login(){
        if(TextUtils.isEmpty(userName.get()) || TextUtils.isEmpty(pwd.get())){
            msgLiveData.value = "用户名或密码为null"
            return
        }
        logDebug(TAG, "userName=${userName.get()!!} pwd=${pwd.get()!!}")
        viewModelScope.launch {
            val result = logRep.login(userName.get()!!, pwd.get()!!)
            result.parseResult({user ->
                UserManager.saveUserInfo(user)
                _loginStateLiveData.value = LoginState.LOGIN
                logDebug(TAG,"login succful")
            },{_, msg ->
                msgLiveData.value = msg
            })
        }

    }

    fun logout():LiveData<Result<EmptyData>> {

        return liveData {
            emit(logRep.unLogout().apply {
                if(isSuccess()){
                    UserManager.clearLogin()
                    RetrofitUtils.clearCookie()
                }
            })

        }


    }

    class Factory @Inject constructor(private val logRep: UserRepository):ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return UserViewModel(logRep) as T
        }

    }

}

enum class LoginState{
    REGIST,
    LOGIN,
}


