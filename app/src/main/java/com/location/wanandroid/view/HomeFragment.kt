package com.location.wanandroid.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.location.base.BaseFragment
import com.location.base.startNewActivity
import com.location.wanandroid.R
import com.location.wanandroid.adapter.HomeAdapter
import com.location.wanandroid.adapter.ItemClickListener
import com.location.wanandroid.data.HomeListData
import com.location.wanandroid.databinding.FragmentHomeBinding
import com.location.wanandroid.view.DetailsActivity.Companion.KEY_URL
import com.location.wanandroid.viewmodel.HomeViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 *
 * @author tianxiaolong
 * time：2021/2/27 10:51 PM
 * description：
 */
class HomeFragment : BaseFragment<FragmentHomeBinding>(), ItemClickListener {
    override val layoutId: Int
        get() = R.layout.fragment_home

    private val adapter by lazy { HomeAdapter(this@HomeFragment) }
    private val homeModel:HomeViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerview.adapter = adapter
        binding.lifecycleOwner = this
        lifecycleScope.launch {
            homeModel.homeFlow.collectLatest {
                adapter.submitData(it)
            }
        }
    }

    override fun onItemClick(data: HomeListData, position: Int) {
        val bundle = bundleOf(KEY_URL to data.link)
        startNewActivity<DetailsActivity>(bundle)
    }

}