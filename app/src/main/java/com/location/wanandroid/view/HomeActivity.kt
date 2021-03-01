package com.location.wanandroid.view

import android.os.Bundle
import android.widget.RadioButton
import androidx.core.view.get
import androidx.viewpager.widget.ViewPager
import com.location.base.BaseActivity
import com.location.wanandroid.R
import com.location.wanandroid.adapter.HomeFragmentAdapter
import com.location.wanandroid.databinding.ActivityHomeBinding
import com.location.wanandroid.padingsource.HomeSourceType

/**
 *
 * @author tianxiaolong
 * time：2021/2/27 4:05 PM
 * description：
 */
class HomeActivity : BaseActivity<ActivityHomeBinding>() {
    override val layoutId: Int
        get() = R.layout.activity_home


    private fun createHomeFragment(type: HomeSourceType) =
        HomeFragment().apply { arguments = HomeFragment.buildBundle(type) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.homeViewpager.adapter = HomeFragmentAdapter(
            supportFragmentManager, mutableListOf(
                createHomeFragment(HomeSourceType.HOME_DATA),
                createHomeFragment(HomeSourceType.QA_DATA),
                createHomeFragment(HomeSourceType.QA_DATA),
                createHomeFragment(HomeSourceType.QA_DATA)
            )
        )
        binding.homeViewpager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                if(position<binding.homeRadioGroup.childCount){
                    val view = binding.homeRadioGroup[position]
                    if(view is RadioButton){
                        view.isChecked = true
                    }
                }
            }
        })

        binding.homeRadioGroup.setOnCheckedChangeListener { _,checkedId ->
            val index = when(checkedId){
                R.id.home_radio_homePage -> 0
                R.id.home_radio_qa -> 1
                R.id.home_radio_system -> 2
                R.id.home_radio_me -> 3
                else -> 1
            }
            binding.homeViewpager.setCurrentItem(index,true)

        }
    }
}

