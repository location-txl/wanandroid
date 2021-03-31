package com.location.wanandroid.view.collect.adapter

import com.location.base.BasePagingDataAdapter
import com.location.base.BaseViewHolder
import com.location.wanandroid.BR
import com.location.wanandroid.R
import com.location.wanandroid.data.CollectArticleItem
import com.location.wanandroid.databinding.ItemCollectBinding

/**
 *
 * @author tianxiaolong
 * time：2021/3/6 6:34 PM
 * description：
 */
class CollectArticleAdapter :
    BasePagingDataAdapter<CollectArticleItem, ItemCollectBinding, ViewHolder>(CollectArticleItem.DiffCallback()) {
    override val layoutId: Int
        get() = R.layout.item_collect

    override fun createViewHolder(binding: ItemCollectBinding): ViewHolder {
        return ViewHolder(binding)
    }
}

class ViewHolder(binding: ItemCollectBinding) :
    BaseViewHolder<ItemCollectBinding, CollectArticleItem>(binding) {
    override fun onBind(data: CollectArticleItem) {
        binding.data = data
        binding.notifyPropertyChanged(BR.data)
    }

}