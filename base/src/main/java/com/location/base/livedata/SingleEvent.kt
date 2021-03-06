package com.location.base.livedata

import androidx.lifecycle.Observer

/**
 *
 * @author tianxiaolong
 * time：2021/3/5 11:34 PM
 * description：
 */
class  Event<out T>(private val data:T){
    private var hasUse =false

    fun getDataIfNotUse():T?{
        return if(hasUse){
            null
        }else{
            hasUse = true
            data
        }
    }
    fun peekContent():T  = data
}

class EventObserver<T>(private val change:(T) -> Unit):Observer<Event<T>>{
    override fun onChanged(t: Event<T>) {
        t.getDataIfNotUse()?.let {
            change(it)
        }
    }
}