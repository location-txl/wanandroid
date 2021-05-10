package com.location.base

import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.location.base.delegate.DaggerActivityDelegate
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

/**
 * @author Xiaolong Tian
 * 实现dagger的自动注入
 */
abstract class BaseDaggerActivity<T : ViewDataBinding> : BaseActivity<T>(),
    HasAndroidInjector {



    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>
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
    }


    override fun androidInjector(): AndroidInjector<Any?>? {
        return androidInjector
    }
}