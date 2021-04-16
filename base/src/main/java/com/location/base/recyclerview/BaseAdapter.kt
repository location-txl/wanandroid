package com.location.base.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.location.base.assertNotNull

/**
 *
 * @author tianxiaolong
 * time：4/15/21 10:06 PM
 * description：
 */
abstract class BaseAdapter<T, VH : BaseViewHolder<*, T>>(diffCallback: DiffUtil.ItemCallback<T>) :
    ListAdapter<T, VH>(diffCallback) {


    open fun viewHolderFactory(viewType: Int): BaseViewHolder.Factory {
        return BaseViewHolder.DefaultFactory()
    }

    //TODO 优化vHClazz
    abstract val vHClazz: Class<VH>

    abstract val layoutId: Int


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {

        val holder = viewHolderFactory(viewType).create(vHClazz, DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            layoutId,
            parent,
            false
        ))
        assertNotNull(holder)
        return holder!!
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(getItem(position))
    }
}
