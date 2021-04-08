package com.location.base


import androidx.activity.viewModels
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelLazy
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import kotlin.reflect.KClass


/**
 * @author Xiaolong Tian
 * 实现ViewModel Factory的自动注入
 */
abstract class BaseDaggerVmActivity<T : ViewDataBinding,  VF : ViewModelProvider.Factory, VM : ViewModel> : BaseDaggerActivity<T>(){

    @Inject
    lateinit var factory: VF

    abstract val viewModelClass: KClass<VM>

    val viewModels  by ViewModelLazy(viewModelClass, { viewModelStore }, { factory })



}