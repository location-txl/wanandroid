package com.location.wanandroid

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.observe
import com.location.base.BaseActivity
import com.location.base.toast
import com.location.wanandroid.databinding.ActivityLoginBinding
import com.location.wanandroid.viewmodels.LoginState
import com.location.wanandroid.viewmodels.UserViewModel

class MainActivity : BaseActivity<ActivityLoginBinding>() {
    override val layoutId: Int
        get() = R.layout.activity_login

    private val userModel: UserViewModel by viewModels()
    private fun loginSuccess(){
        finish()
    }

    private fun registerSuccess() {

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.userModel = userModel

        userModel.msgLiveData().observe(this) {
            toast(it)
        }
        userModel.loginStateLiveData().observe(this) {
            when (it) {
                LoginState.LOGIN -> loginSuccess()
                LoginState.REGIST -> registerSuccess()
            }
        }
    }


}