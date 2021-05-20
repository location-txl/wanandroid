package com.location.activitysample.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.launcher.ARouter
import com.location.activitysample.Navigation
import com.location.activitysample.databinding.ActivitySampleActivityMainBinding
import com.location.activitysample.test

/**
 *
 * @author tianxiaolong
 * time：5/20/21 10:40 PM
 * description：
 */
abstract class BaseTestActivity : AppCompatActivity() {
    val binding by lazy { ActivitySampleActivityMainBinding.inflate(layoutInflater) }
    abstract fun currentNum():Int
    abstract val subTitle:String
    private val currentIndex by lazy { currentNum() }
    private val activityLifecycle by lazy { ActivityLifecycle("${subTitle}-${currentIndex}") }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        lifecycle.addObserver(activityLifecycle)
        title = "$subTitle-$currentIndex"
        binding.gotoStandActivity.setOnClickListener {
            ARouter.getInstance().build(Navigation.COMOON_ONE_ACTIVITY).navigation()
        }
        binding.gotoSingleTopActivity.setOnClickListener {
            ARouter.getInstance().build(Navigation.COMOON_TWO_ACTIVITY).navigation()
        }
        binding.gotoSingleTaskActivity.setOnClickListener {
            ARouter.getInstance().build(Navigation.COMOON_THREE_ACTIVITY).navigation()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        activityLifecycle.onSaveInstance()
    }

    override fun onRestart() {
        super.onRestart()
        activityLifecycle.onRestart()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        activityLifecycle.onNewIntent()
    }

}