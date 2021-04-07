package com.location.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.observe
import com.location.base.delegate.DaggerActivityDelegate
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity(), HasAndroidInjector {


    abstract val layoutId: Int

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    protected val binding: T by lazy {
        DataBindingUtil.setContentView<T>(
            this, layoutId
        )
    }


    /**
     * 是否支持依赖注入
     * @return Boolean
     */
    open fun supportInject() = true

    override fun onCreate(savedInstanceState: Bundle?) {
        if(supportInject()){
            DaggerActivityDelegate.create().inject(this)
        }
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


    override fun androidInjector(): AndroidInjector<Any?>? {
        return androidInjector
    }



}