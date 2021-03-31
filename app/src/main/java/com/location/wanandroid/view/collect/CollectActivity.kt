package com.location.wanandroid.view.collect

import android.os.Bundle
import com.location.base.BaseActivity
import com.location.wanandroid.R
import com.location.wanandroid.view.collect.adapter.CollectFragmentAdapter
import com.location.wanandroid.databinding.ActivityCollectBinding

/**
 *
 * @author tianxiaolong
 * time：2021/3/6 4:37 PM
 * description：
 */
class CollectActivity:BaseActivity<ActivityCollectBinding>(){
    override val layoutId: Int
        get() = R.layout.activity_collect

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding.viewPager.adapter =
             CollectFragmentAdapter(
                 supportFragmentManager, mutableListOf(
                     CollectArticleFragment(),
                     CollectArticleFragment()

                 ), mutableListOf("文章", "网址")
             )
        binding.tableLayout.setupWithViewPager(binding.viewPager)

    }

}

