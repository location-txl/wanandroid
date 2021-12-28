package com.location.base.recyclerview

import android.view.View
import androidx.databinding.ViewDataBinding

/**
 *
 * @author tianxiaolong
 * time：4/16/21 10:28 PM
 * description：支持Item点击
 * @param itemClick item点击回调
 * @constructor
 */
abstract class BaseClickHolder<V : ViewDataBinding, T>(binding: V, itemClick: ItemClickListener?) :
    BaseViewHolder<V, T>(binding) {

    init {
        itemClick?.let {
            itemView.setOnClickListener {
                val adapter = bindingAdapter
                if (adapter is ItemDataProvider<*>) {
                    with(itemClick) {
                        onItemClick(
                            it,
                            binding,
                            bindingAdapterPosition,
                            adapter.getItemData(bindingAdapterPosition)
                        )
                    }
                }

            }
        }

    }

    /**
     * 支持设置Item点击的工厂类
     * @property itemClick ItemClickListener? item点击回调
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

    /**
     * [androidx.recyclerview.widget.RecyclerView] item的点击回调
     */
    interface ItemClickListener {
        /**
         * Item点击
         * @param view View 点击的view
         * @param binding V DataBinding
         * @param position Int item索引
         */
        fun <V : ViewDataBinding, T> onItemClick(view: View, binding: V, position: Int, data: T)
    }
}