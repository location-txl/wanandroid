package com.location.base

import android.util.Log

/**
 *
 * @author tianxiaolong
 * time：2021/1/29 11:10 PM
 * description：
 */
const val  TAG = "wanadnroid"

fun Any.logDebug(tag:String? = null,msg:String){

    if(BuildConfig.DEBUG){
        val logTag = if(tag == null) TAG else "${TAG}_$tag"
        Log.d(logTag,msg)
    }

}