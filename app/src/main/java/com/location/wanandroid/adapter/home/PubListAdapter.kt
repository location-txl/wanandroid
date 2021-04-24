package com.location.wanandroid.adapter.home

import com.location.base.BR
import com.location.base.recyclerview.BaseClickHolder
import com.location.base.recyclerview.BasePagingDataAdapter
import com.location.base.recyclerview.BaseViewHolder
import com.location.wanandroid.R
import com.location.wanandroid.data.PublicList
import com.location.wanandroid.databinding.ItemListBinding

/**
 *
 * @author tianxiaolong
 * time：2021/2/27 11:00 PM
 * description：
 * 公众号文章
 */
class PubListAdapter(private val listener: BaseClickHolder.ItemClickListener) :
    BasePagingDataAdapter<PublicList, PubListAdapter.PublicListViewHolder>(
        PublicList.DiffCallback()
    )

{
    override fun viewHolderFactory(): BaseViewHolder.Factory {
        return BaseClickHolder.DefaultClickFactory(listener)
    }



    override val layoutId: Int
        get() = R.layout.item_list
    override val vHClazz: Class<PublicListViewHolder>
        get() = PublicListViewHolder::class.java




    class PublicListViewHolder(
        binding: ItemListBinding, itemClick: ItemClickListener?
    ) :
        BaseClickHolder<ItemListBinding, PublicList>(binding, itemClick) {
        override fun onBind(data: PublicList) {
            binding.data = data
            binding.notifyPropertyChanged(BR.data)
        }
    }

}