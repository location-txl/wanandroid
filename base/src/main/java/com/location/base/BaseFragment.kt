package com.location.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

/**
 *
 * @author tianxiaolong
 * time：2021/2/27 10:53 PM
 * description：
 */
abstract class BaseFragment<T: ViewDataBinding> : Fragment() {
    abstract val layoutId:Int

    lateinit var binding:T
    private set

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,layoutId,container,false)
        return binding.root
    }

}