package com.location.base.delegate

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.location.base.assertNotNull
import com.location.base.logDebug
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection

/**
 *
 * @author tianxiaolong
 * time：2021/4/6 10:45 PM
 * description：
 */
class DaggerFragmentDelegate {




    companion object{
        internal fun create():DaggerFragmentDelegate{
            return DaggerFragmentDelegate()
        }
    }

    internal  fun inject(fragment:Fragment){
        AndroidSupportInjection.inject(fragment)
    }



}