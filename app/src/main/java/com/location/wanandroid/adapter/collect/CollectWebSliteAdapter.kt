package com.location.wanandroid.adapter.collect

import com.location.base.recyclerview.BaseAdapter
import com.location.base.recyclerview.BaseViewHolder
import com.location.wanandroid.BR
import com.location.wanandroid.R
import com.location.wanandroid.data.collect.CollectWebSlite
import com.location.wanandroid.databinding.ItemCollectWebsliteBinding


/**
 *
 * @author tianxiaolong
 * time：4/15/21 10:05 PM
 * description：
 */
class CollectWebSliteAdapter :
    BaseAdapter<CollectWebSlite, CollectWebSliteAdapter.ViewHolder>(CollectWebSlite.DiffCallback()) {
    override val vHClazz: Class<ViewHolder>
        get() = ViewHolder::class.java
    override val layoutId: Int
        get() = R.layout.item_collect_webslite

    class ViewHolder(binding: ItemCollectWebsliteBinding) :
        BaseViewHolder<ItemCollectWebsliteBinding, CollectWebSlite>(binding) {
        override fun onBind(data: CollectWebSlite) {
            binding.webSlite = data
            binding.notifyPropertyChanged(BR.webSlite)
        }
    }
}


