package com.location.base.recyclerview

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 *
 * @author tianxiaolong
 * time：2021/2/27 11:49 PM
 * description：
 */
abstract class BaseViewHolder<V : ViewDataBinding, T>(val binding: V) :
    RecyclerView.ViewHolder(binding.root) {
    abstract fun onBind(data: T)

    interface Factory {
        /**
         * 创建ViewHolder
         * @param clazz Class<VH> 当前ViewHolder的类型
         * @param binding ViewDataBinding 数据绑定Binding
         * @param viewType item类型
         */
        fun <VH : BaseViewHolder<*, *>> create(
            clazz: Class<VH>,
            binding: ViewDataBinding,
            viewType: Int
        ): VH
    }

    open class DefaultFactory : Factory {
        /**
         *@throws NoSuchMethodException
         */
        override fun <VH : BaseViewHolder<*, *>> create(
            clazz: Class<VH>,
            binding: ViewDataBinding,
            viewType: Int
        ): VH {
            try {
                return clazz.getConstructor(binding::class.java.superclass).newInstance(binding)
            } catch (e: NoSuchMethodException) {
                throw e
            }
        }
    }

}
