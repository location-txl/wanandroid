package com.location.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.location.base.delegate.DaggerFragmentDelegate
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

/**
 *
 * @author tianxiaolong
 * time：2021/2/27 10:53 PM
 * description：
 */
abstract class BaseDaggerVmFragment<T: ViewDataBinding,  VF: ViewModelProvider.Factory> : BaseDaggerFragment<T>() {



    @Inject
    lateinit var factory:VF

    override fun onAttach(context: Context) {
        super.onAttach(context)
        assertNotNull(factory)
    }
}