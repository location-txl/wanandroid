package com.location.activitysample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.location.activitysample.databinding.ActivitySampleActivityHomeBinding
import com.location.activitysample.databinding.ActivitySampleActivityMainBinding

@Route(path = Navigation.COMMON_SAMPLE)
class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivitySampleActivityHomeBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        title = "四大组件"
        binding.gotoActivity.setOnClickListener {
            ARouter.getInstance().build(Navigation.COMOON_ONE_ACTIVITY).navigation()
        }
    }
}