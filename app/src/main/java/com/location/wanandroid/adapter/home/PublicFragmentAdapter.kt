package com.location.wanandroid.adapter.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.location.base.logDebug

/**
 *
 * @author tianxiaolong
 * time：4/20/21 10:16 PM
 * description：
 */
class PublicFragmentAdapter(fragment: Fragment,private val fragments:List<Fragment>) : FragmentStateAdapter(fragment) {
    private val TAG = "PublicFragmentAdapter"
    override fun getItemCount(): Int {
       return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        logDebug(TAG,"createFragment position:$position")
        return fragments[position]
    }

}