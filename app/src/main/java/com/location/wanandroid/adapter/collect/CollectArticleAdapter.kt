package com.location.wanandroid.adapter.coolect

import com.location.base.BasePagingDataAdapter
import com.location.base.BaseViewHolder
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
class CollectArticleAdapter :
    BasePagingDataAdapter<CollectArticleItem, ViewHolder>(
        CollectArticleItem.DiffCallback()) {
    override val layoutId: Int
        get() = R.layout.item_collect
    override val vHClazz: Class<ViewHolder>
        get() = ViewHolder::class.java

}

class ViewHolder(binding: ItemCollectBinding) :
    BaseViewHolder<ItemCollectBinding, CollectArticleItem>(binding) {
    override fun onBind(data: CollectArticleItem) {
        binding.data = data
        binding.notifyPropertyChanged(BR.data)
    }

}