package com.location.base

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.fragment.app.Fragment
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

/**
 *
 * @author tianxiaolong
 * time：2021/1/29 11:10 PM
 * description：
 */
const val  TAG = "wanadnroid"


fun logDebug(tag: String? = null, msg: String){

    if(BuildConfig.DEBUG){
        val logTag = if(tag == null) TAG else "${TAG}_$tag"
        Log.d(logTag,msg)
    }
}
fun Activity.toast(msg:String){
    Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
}

suspend fun <T> DataStore<Preferences>.getData(key: Preferences.Key<T>, defaultValue: T): T {
    return data.map {
        it[key] ?: defaultValue
    }.first()
}

inline fun  <reified T:Activity> Activity.startNewActivity(bundle:Bundle = Bundle()){
    startActivity(Intent(this,T::class.java).apply {
            putExtras(bundle)
    })
}
inline fun  <reified T:Activity> Fragment.startNewActivity(bundle:Bundle = Bundle()){
    startActivity(Intent(requireActivity(),T::class.java).apply {
            putExtras(bundle)
    })
}

