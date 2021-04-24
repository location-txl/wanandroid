package com.location.base.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

/**
 *
 * @author tianxiaolong
 * time：4/15/21 10:06 PM
 * description：
 * RecyclerView基础BaseAdapter
 *
 * @param T 数据类型
 * @param VH ViewHolder 需要继承 [BaseViewHolder]
 * @param diffCallback 内容对比器
 */
abstract class BaseAdapter<T, VH : BaseViewHolder<*, T>>(diffCallback: DiffUtil.ItemCallback<T>) :
    ListAdapter<T, VH>(diffCallback),ItemDataProvider<T> {


    /**
     *
     * @return BaseViewHolder.Factory 返回ViewHolder工厂
     * @see BaseViewHolder.DefaultFactory
     * @see BaseClickHolder.DefaultClickFactory
     */
    open fun viewHolderFactory(): BaseViewHolder.Factory {
        return BaseViewHolder.DefaultFactory()
    }

    //TODO 优化vHClazz
    /**
     * 返回 [VH] 的class类型
     */
    abstract val vHClazz: Class<VH>

    /**
     * 返回布局ID
     */
     abstract  val layoutId: Int



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


    public override fun getItem(position: Int): T {
        return super.getItem(position)
    }
    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(getItem(position))
    }

    override fun  getItemData(position: Int): T {
        return getItem(position)
    }
}
