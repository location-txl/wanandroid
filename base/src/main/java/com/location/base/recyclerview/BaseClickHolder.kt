package com.location.base.recyclerview

import android.view.View
import androidx.databinding.ViewDataBinding

/**
 *
 * @author tianxiaolong
 * time：4/16/21 10:28 PM
 * description：支持Item点击
 */
abstract class BaseClickHolder<V : ViewDataBinding, T>(binding: V, itemClick: ItemClickListener?) :
    BaseViewHolder<V, T>(binding) {

    init {
        itemClick?.let { itemClick ->
            itemView.setOnClickListener {
                itemClick.onItemClick(it, binding, layoutPosition)
            }
        }

    }

    /**
     * 支持设置Item点击的工厂类
     * @property itemClick ItemClickListener?
     * @constructor
     */
    class DefaultClickFactory(private val itemClick: ItemClickListener?) : DefaultFactory() {
        override fun <VH : BaseViewHolder<*, *>> create(
            clazz: Class<VH>,
            binding: ViewDataBinding,
            viewType: Int
        ): VH {
            return try {
                clazz.getConstructor(
                    binding::class.java.superclass,
                    ItemClickListener::class.java
                ).newInstance(binding, itemClick)
            } catch (e: NoSuchMethodException) {
                e.printStackTrace()
                super.create(clazz, binding, viewType)
            }

        }
    }

    interface ItemClickListener {
        /**
         * Item点击
         * @param view View 点击的view
         * @param binding V DataBinding
         * @param position Int item索引
         */
        fun <V : ViewDataBinding> onItemClick(view: View, binding: V, position: Int)
    }
}