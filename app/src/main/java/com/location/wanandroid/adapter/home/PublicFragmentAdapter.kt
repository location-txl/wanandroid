package com.location.wanandroid.adapter.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.location.base.logDebug
import com.location.wanandroid.data.PublicArticle
import com.location.wanandroid.view.home.PublicChildFragment
import com.location.wanandroid.view.home.PublicFragment

/**
 *
 * @author tianxiaolong
 * time：4/20/21 10:16 PM
 * description：
 */
class PublicFragmentAdapter(fragment: Fragment,private val publics:List<PublicArticle>) : FragmentStateAdapter(fragment) {
    private val TAG = "PublicFragmentAdapter"

    override fun getItemCount(): Int {
       return publics.size
    }

    override fun createFragment(position: Int): Fragment {
        logDebug(TAG,"createFragment position:$position")
        return PublicChildFragment.newInstance(publics[position].id)
    }

}