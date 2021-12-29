package com.location.wanandroid.adapter.collect

import androidx.databinding.ViewDataBinding
import com.location.base.recyclerview.BasePagingDataAdapter
import com.location.base.recyclerview.BaseViewHolder
import com.location.wanandroid.BR
import com.location.wanandroid.R
import com.location.wanandroid.data.collect.CollectArticleItem
import com.location.wanandroid.databinding.ItemCollectBinding

/**
 *
 * @author tianxiaolong
 * time：2021/3/6 6:34 PM
 * description：
 */
class CollectArticleAdapter(val removeCollectFunc:(pos:Int,item:CollectArticleItem) -> Unit) :
    BasePagingDataAdapter<CollectArticleItem, CollectArticleAdapter.ViewHolder>(
        CollectArticleItem.DiffCallback()) {
    override val layoutId: Int
        get() = R.layout.item_collect
    override val vHClazz: Class<ViewHolder>
        get() = ViewHolder::class.java

    override fun viewHolderFactory(): BaseViewHolder.Factory {
        return Factory(removeCollectFunc)
    }
    class ViewHolder(binding: ItemCollectBinding,val removeCollectFunc:(pos:Int,item:CollectArticleItem) -> Unit) :
        BaseViewHolder<ItemCollectBinding, CollectArticleItem>(binding) {
        override fun onBind(data: CollectArticleItem) {
            binding.data = data
            binding.removeCollect.setOnClickListener {
                removeCollectFunc(layoutPosition,data)
            }
            binding.notifyPropertyChanged(BR.data)
        }
    }
    class Factory(val removeCollectFunc:(pos:Int,item:CollectArticleItem) -> Unit):BaseViewHolder.Factory{
        override fun <VH : BaseViewHolder<*, *>> create(
            clazz: Class<VH>,
            binding: ViewDataBinding,
            viewType: Int
        ): VH {
            @Suppress("UNCHECKED_CAST")
            return ViewHolder(
                binding as ItemCollectBinding,
                removeCollectFunc
            ) as VH
        }

    }
}


