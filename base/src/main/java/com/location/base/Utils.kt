package com.location.base

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.content.Intent
import android.os.Build.VERSION.SDK_INT
import android.os.Build.VERSION_CODES.KITKAT
import android.os.Bundle
import android.util.Log
import android.view.ViewTreeObserver
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.fragment.app.Fragment
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import java.lang.reflect.Field
import java.lang.reflect.Method


/**
 *
 * @author tianxiaolong
 * time：2021/1/29 11:10 PM
 * description：
 */
const val TAG = "wanadnroid"


fun logDebug(tag: String? = null, msg: String) {

    if (BuildConfig.DEBUG) {
        val logTag = if (tag == null) TAG else "${TAG}_$tag"
        Log.d(logTag, msg)
    }
}

fun Activity.toast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

suspend fun <T> DataStore<Preferences>.getData(key: Preferences.Key<T>, defaultValue: T): T {
    return data.map {
        it[key] ?: defaultValue
    }.first()
}

inline fun <reified T : Activity> Activity.startNewActivity(bundle: Bundle = Bundle()) {
    startActivity(Intent(this, T::class.java).apply {
        putExtras(bundle)
    })
}

inline fun <reified T : Activity> Fragment.startNewActivity(bundle: Bundle = Bundle()) {
    startActivity(Intent(requireActivity(), T::class.java).apply {
        putExtras(bundle)
    })
}


fun fixInputMethodManagerLeak(context: Context) {
    try {
        // 对 mCurRootView mServedView mNextServedView 进行置空...
        val imm: InputMethodManager =
            context.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager

        // author:sodino mail:sodino@qq.com

        var obj_get: Any? = null;
        val f_mCurRootView = imm.javaClass.getDeclaredField("mCurRootView")
        val f_mServedView = imm.javaClass.getDeclaredField("mServedView")
        val f_mNextServedView = imm.javaClass.getDeclaredField("mNextServedView")

        if (f_mCurRootView.isAccessible) {
            f_mCurRootView.isAccessible = true
        }
        obj_get = f_mCurRootView.get(imm)
        if (obj_get != null) { // 不为null则置为空
            f_mCurRootView.set(imm, null);
        }

        if (!f_mServedView.isAccessible) {
            f_mServedView.isAccessible = true;
        }
        obj_get = f_mServedView.get(imm);
        if (obj_get != null) { // 不为null则置为空
            f_mServedView.set(imm, null);
        }

        if (!f_mNextServedView.isAccessible) {
            f_mNextServedView.isAccessible = true;
        }
        obj_get = f_mNextServedView.get(imm);
        if (obj_get != null) { // 不为null则置为空
            f_mNextServedView.set(imm, null);
        }
    } catch (t: Throwable) {
        t.printStackTrace()
    }

}


