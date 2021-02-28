package com.location.wanandroid.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.location.base.BaseActivity
import com.location.wanandroid.R
import com.location.wanandroid.adapter.HomeFragmentAdapter
import com.location.wanandroid.databinding.ActivityHomeBinding
import com.location.wanandroid.databinding.ActivityLoginBinding

/**
 *
 * @author tianxiaolong
 * time：2021/2/27 4:05 PM
 * description：
 */
class HomeActivity: BaseActivity<ActivityHomeBinding>() {
    override val layoutId: Int
        get() = R.layout.activity_home

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.homeViewpager.adapter = HomeFragmentAdapter(supportFragmentManager, mutableListOf(HomeFragment()))
    }
}

