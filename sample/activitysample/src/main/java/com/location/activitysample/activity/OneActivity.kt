package com.location.activitysample.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.location.activitysample.Navigation
import com.location.activitysample.databinding.ActivitySampleActivityMainBinding

/**
 *
 * @author tianxiaolong
 * time：5/20/21 10:21 PM
 * description：
 */
private var num = 1

@Route(path = Navigation.COMOON_ONE_ACTIVITY)
class OneActivity: BaseTestActivity() {
    override fun currentNum(): Int {
        return num++
    }

    override val subTitle: String
        get() = "Stand-OneActivity"


}