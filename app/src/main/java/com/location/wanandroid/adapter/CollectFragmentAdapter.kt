package com.location.wanandroid.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 *
 * @author tianxiaolong
 * time：2021/3/6 4:52 PM
 * description：
 */
class CollectFragmentAdapter(fm: FragmentManager, private val fragments:List<Fragment>,private val titles:List<String>): FragmentPagerAdapter(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int) = fragments[position]

    override fun getCount() = fragments.size

    override fun getPageTitle(position: Int) = titles[position]
}