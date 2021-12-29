package com.location.wanandroid.view.collect

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.location.base.BaseDaggerVmFragment
import com.location.wanandroid.R
import com.location.wanandroid.adapter.collect.CollectArticleAdapter
import com.location.wanandroid.data.collect.CollectArticleItem
import com.location.wanandroid.databinding.FragmentHomeBinding
import com.location.wanandroid.viewmodels.collect.CollectViewModel
import kotlinx.coroutines.flow.collectLatest

/**
 *
 * @author tianxiaolong
 * time：2021/3/6 4:58 PM
 * description：
 */
class CollectArticleFragment :
    BaseDaggerVmFragment<FragmentHomeBinding, CollectViewModel.Factory>() {
    private val viewModel: CollectViewModel by viewModels { factory }
    private val adapter = CollectArticleAdapter(this::removeCollect)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerview.adapter = adapter
        lifecycleScope.launchWhenResumed {
            viewModel.coolectArticleFlow.collectLatest {
                adapter.submitData(it)
            }
        }
    }

    override val layoutId: Int
        get() = R.layout.fragment_home


    fun removeCollect(pos:Int,item: CollectArticleItem){
        viewModel.remove(item)
    }
}