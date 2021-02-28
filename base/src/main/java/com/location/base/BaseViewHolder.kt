package com.location.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 *
 * @author tianxiaolong
 * time：2021/2/27 11:49 PM
 * description：
 */
abstract class BaseViewHolder<D:ViewDataBinding,T>(val binding:D) :RecyclerView.ViewHolder(binding.root){
    abstract fun onBind(data:T)
}
