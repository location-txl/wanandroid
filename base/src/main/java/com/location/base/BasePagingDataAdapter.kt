package com.location.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil

/**
 *
 * @author tianxiaolong
 * time：2021/2/28 6:00 PM
 * description：
 */
abstract class BasePagingDataAdapter<T : Any, V : ViewDataBinding, VH : BaseViewHolder<V, T>>(
    diffCallback: DiffUtil.ItemCallback<T>
) :
    PagingDataAdapter<T, VH>(diffCallback) {

    abstract val layoutId: Int
    abstract fun createViewHolder(binding: V): VH

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(getItem(position)!!)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return createViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                layoutId,
                parent,
                false
            )
        )
    }


}