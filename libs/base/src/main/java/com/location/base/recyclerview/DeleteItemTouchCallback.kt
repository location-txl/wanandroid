package com.location.base.recyclerview

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

/**
 *
 * @author tianxiaolong
 * time：2021/12/29 2:25 下午
 * description：支持Item滑动删除 删除后会收到[ItemDeleteCallback.delete]回调
 */
class DeleteItemTouchCallback(private val callback:ItemDeleteCallback): ItemTouchHelper.Callback() {
    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        return makeMovementFlags(0, ItemTouchHelper.RIGHT)
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return true
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        callback.delete(viewHolder.layoutPosition)
    }

    interface ItemDeleteCallback{
        fun delete(position:Int)
    }

}