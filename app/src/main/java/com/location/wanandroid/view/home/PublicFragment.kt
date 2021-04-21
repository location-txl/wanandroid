package com.location.wanandroid.view.home

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.google.android.material.tabs.TabLayoutMediator
import com.location.base.*
import com.location.wanandroid.*
import com.location.wanandroid.adapter.home.HomeAdapter
import com.location.wanandroid.adapter.home.ItemClickListener
import com.location.wanandroid.data.HomeListData
import com.location.wanandroid.view.DetailsActivity.Companion.KEY_URL
import com.location.wanandroid.viewmodels.home.HomeViewModel
import com.location.base.widget.FavoritesView
import com.location.wanandroid.R
import com.location.wanandroid.adapter.home.PublicFragmentAdapter
import com.location.wanandroid.data.PublicArticle
import com.location.wanandroid.databinding.FragmentPublicBinding
import com.location.wanandroid.view.DetailsActivity
import kotlinx.coroutines.launch

/**
 *
 * @author tianxiaolong
 * time：2021/2/27 10:51 PM
 * description：
 * viewpager2
 * https://developer.android.google.cn/training/animation/vp2-migration?hl=zh_cn#layout-files
 */
class PublicFragment : BaseDaggerVmFragment<FragmentPublicBinding,HomeViewModel.Factory>(){





    override val layoutId: Int
        get() = R.layout.fragment_public



    private val homeModel: HomeViewModel by activityViewModels {factory}



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this

        /**
         * tableLayout和Viewpager2的联动方式
         */
        homeModel.getpublic()
            .observe(viewLifecycleOwner, Observer {
                binding.viewPager.adapter = PublicFragmentAdapter(this,it)
                TabLayoutMediator(binding.tableLayout, binding.viewPager) { tab, position ->
                    tab.text = it[position].name
                }.attach()
            })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        fixInputMethodManagerLeak(appContext)
    }

}