package com.location.wanandroid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.location.base.BaseViewHolder
import com.location.wanandroid.BR
import com.location.wanandroid.R
import com.location.wanandroid.data.HomeListData
import com.location.wanandroid.data.HomeListDataDiff
import com.location.wanandroid.databinding.ItemHomeBinding
import com.location.wanandroid.widget.FavoritesView

/**
 *
 * @author tianxiaolong
 * time：2021/2/27 11:00 PM
 * description：
 */
class HomeAdapter(private val listener: ItemClickListener) :
    PagingDataAdapter<HomeListData, HomeViewHolder>(
        HomeListDataDiff()
    ) {
    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.onBind(getItem(position)!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_home,
                parent,
                false
            )
            , { position ->
                listener.onItemClick(getItem(position)!!, position)
            }, { position,checked,view ->
                listener.onCollect(getItem(position)!!, position,checked,view)
            })
    }
}

class HomeViewHolder(
    binding: ItemHomeBinding,
    private val click: (Int) -> Unit,
    private val collectClick: (Int,Boolean,FavoritesView) -> Unit
) :
    BaseViewHolder<ItemHomeBinding, HomeListData>(binding) {
    init {

        itemView.setOnClickListener {
            click(layoutPosition)
        }
        binding.collectBtn.setOnClickListener {
            collectClick(layoutPosition,binding.collectBtn.isChecked,binding.collectBtn)
//            binding.collectBtn.toggle()
        }
    }

    override fun onBind(data: HomeListData) {
        binding.setVariable(BR.homeData, data)
        binding.executePendingBindings()
    }
}

interface ItemClickListener {

    fun onItemClick(data: HomeListData, position: Int)

    fun onCollect(data: HomeListData, position: Int,collect: Boolean,view:FavoritesView)
}



