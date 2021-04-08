package com.location.base


import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject



/**
 * @author Xiaolong Tian
 * 实现ViewModel Factory的自动注入
 */
abstract class BaseDaggerVmActivity<T : ViewDataBinding,  VF:ViewModelProvider.Factory> : BaseDaggerActivity<T>(){

    @Inject
    lateinit var factory:VF

}