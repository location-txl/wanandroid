package com.location.wanandroid.view.collect

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ItemTouchHelper
import com.location.base.BaseDaggerVmFragment
import com.location.base.recyclerview.DeleteItemTouchCallback
import com.location.base.startNewActivity
import com.location.base.toast
import com.location.wanandroid.R
import com.location.wanandroid.adapter.collect.CollectArticleAdapter
import com.location.wanandroid.data.collect.CollectArticleItem
import com.location.wanandroid.databinding.FragmentHomeBinding
import com.location.wanandroid.view.DetailsActivity
import com.location.wanandroid.viewmodels.collect.CollectViewModel
import kotlinx.coroutines.flow.collectLatest

/**
 *
 * @author tianxiaolong
 * time：2021/3/6 4:58 PM
 * description：我的收藏文章界面
 */
class CollectArticleFragment :
    BaseDaggerVmFragment<FragmentHomeBinding, CollectViewModel.Factory>(),
    DeleteItemTouchCallback.ItemDeleteCallback {
    private val viewModel: CollectViewModel by viewModels { factory }
    private val adapter = CollectArticleAdapter(this::removeCollect,this::itemClick)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerview.adapter = adapter
        lifecycleScope.launchWhenResumed {
            viewModel.coolectArticleFlow.collectLatest {
                adapter.submitData(it)
            }
        }
        ItemTouchHelper(DeleteItemTouchCallback(this))
            .attachToRecyclerView(binding.recyclerview)
    }

    override val layoutId: Int
        get() = R.layout.fragment_home


    fun removeCollect(pos:Int,item: CollectArticleItem){
        unCollect(pos)
    }
    fun itemClick(pos:Int,item: CollectArticleItem){
        startNewActivity<DetailsActivity>{
            putExtras(bundleOf(DetailsActivity.KEY_URL to item.link))
        }
    }

    override fun delete(position: Int) {
        unCollect(position)
    }

    private fun unCollect(position: Int) {
        lifecycleScope.launchWhenResumed {
            val itemData = adapter.getItemData(position)
            if (viewModel.removeRemoteData(itemData)) {
                viewModel.removeLocalData(itemData)
            } else {
                adapter.notifyItemChanged(position)
                toast("取消收藏失败")
            }
        }
    }
}
