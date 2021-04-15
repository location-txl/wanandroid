package com.location.wanandroid

import android.os.Bundle
import androidx.lifecycle.observe
import com.location.base.BaseDaggerVmActivity
import com.location.base.toast
import com.location.wanandroid.databinding.ActivityLoginBinding
import com.location.wanandroid.viewmodels.LoginState
import com.location.wanandroid.viewmodels.UserViewModel
import kotlin.reflect.KClass

class MainActivity : BaseDaggerVmActivity<ActivityLoginBinding,UserViewModel.Factory,UserViewModel>() {
    override val layoutId: Int
        get() = R.layout.activity_login



    private fun loginSuccess() {
        finish()
    }

    private fun registerSuccess() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.userModel = viewModels
        viewModels.msgLiveData().observe(this) {
            toast(it)
        }
        viewModels.loginStateLiveData().observe(this) {
            when (it) {
                LoginState.LOGIN -> loginSuccess()
                LoginState.REGIST -> registerSuccess()
            }
        }
    }

    override val viewModelClass: KClass<UserViewModel>
        get() = UserViewModel::class


}