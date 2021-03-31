package com.location.wanandroid.view.home.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 *
 * @author tianxiaolong
 * time：2021/2/28 2:59 PM
 * description：
 */
class HomeFragmentAdapter(fm: FragmentManager, private val fragments:List<Fragment>) : FragmentPagerAdapter(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return  fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

}