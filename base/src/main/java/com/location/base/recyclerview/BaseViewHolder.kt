package com.location.base.recyclerview

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 *
 * @author tianxiaolong
 * time：2021/2/27 11:49 PM
 * description：
 */
abstract class BaseViewHolder<V:ViewDataBinding,T>(val binding:V) :RecyclerView.ViewHolder(binding.root){
    abstract fun onBind(data:T)


    interface Factory{
        fun <VH: BaseViewHolder<*, *>> create(clazz: Class<VH>, binding: ViewDataBinding):VH?
    }

    class DefaultFactory : Factory {

        override fun <VH : BaseViewHolder<*, *>> create(clazz: Class<VH>, binding: ViewDataBinding): VH? {
            try {
                return clazz.getConstructor(binding::class.java.superclass).newInstance(binding)
            } catch (e: NoSuchMethodException) {
                e.printStackTrace()
            }
            return null
        }


    }

}
