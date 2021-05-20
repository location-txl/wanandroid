package com.location.activitysample.activity

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.location.base.logDebug
import kotlin.math.log

/**
 *
 * @author tianxiaolong
 * time：5/20/21 10:31 PM
 * description：
 */

class ActivityLifecycle(private val tag:String):LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate(){
        logDebug(tag,"event-onCreate")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart(){
        logDebug(tag,"event-onStart")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume(){
        logDebug(tag,"event-onResume")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause(){
        logDebug(tag,"event-onPause")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop(){
        logDebug(tag,"event-onStop")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy(){
        logDebug(tag,"event-onDestroy")
    }

    fun onRestart(){
        logDebug(tag,"event-onRestart")
    }

    fun onSaveInstance(){
        logDebug(tag,"event-onSaveInstance")
    }

    fun onNewIntent(){
        logDebug(tag,"event-onNewIntent")
    }
}