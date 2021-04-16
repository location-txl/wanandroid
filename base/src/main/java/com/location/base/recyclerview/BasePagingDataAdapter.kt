package com.location.base.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil

/**
 *
 * @author tianxiaolong
 * time：2021/2/28 6:00 PM
 * description：
 */
abstract class BasePagingDataAdapter<T : Any, VH : BaseViewHolder<*, T>>(
    diffCallback: DiffUtil.ItemCallback<T>
) :
    PagingDataAdapter<T, VH>(diffCallback) {

    abstract val layoutId: Int

    //TODO 优化vHClazz
    abstract val vHClazz: Class<VH>

    open fun viewHolderFactory(): BaseViewHolder.Factory = BaseViewHolder.DefaultFactory()


    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(getItem(position)!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return viewHolderFactory().create(
            vHClazz, DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                layoutId,
                parent,
                false
            ), viewType
        )

    }


}