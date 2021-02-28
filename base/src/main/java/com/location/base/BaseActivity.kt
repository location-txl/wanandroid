package com.location.base

import android.os.Bundle
import android.text.Html
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.observe

abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity() {


    abstract val layoutId: Int

    protected val binding: T by lazy {
        DataBindingUtil.setContentView<T>(
            this, layoutId
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this
        init()
    }

    private fun init(){
        StatusManager.loadingLiveData.observe(this) {
            when (it) {
                LoadingStatus.SHOW_LOADING -> {

                }
                LoadingStatus.HIDE_LOADING -> {

                }
                else -> {

                }
            }
        }
    }

    protected fun showDialLog() {

    }

    protected fun hideDialog() {

    }






}