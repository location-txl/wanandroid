package com.location.base

import android.app.Activity
import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.content.Intent
import android.util.Log
import android.view.inputmethod.InputMethodManager
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

fun Fragment.toast(msg:String){
    Toast.makeText(requireContext(),msg,Toast.LENGTH_SHORT).show()
}

suspend fun <T> DataStore<Preferences>.getData(key: Preferences.Key<T>, defaultValue: T): T {
    return data.map {
        it[key] ?: defaultValue
    }.first()
}

inline fun <reified T : Activity> Activity.startNewActivity(block: Intent.() -> Unit = {}) {
    startActivity(Intent(this, T::class.java).apply {
        block()
    })
}



inline fun <reified T : Activity> Fragment.startNewActivity(block: Intent.() -> Unit = {}) {
    startActivity(Intent(requireActivity(), T::class.java).apply {
        block()
    })
}

@Suppress("NOTHING_TO_INLINE")
inline fun <T : Any> assertNotNull(value: T?) {

    if (BuildConfig.DEBUG) {
        requireNotNull(value)
    }
}

inline fun <T : Any> assertNotNull(value: T?, message: () -> String) {

    if (BuildConfig.DEBUG) {
        requireNotNull(value) {
            message()
        }
    }
}

@Suppress("NOTHING_TO_INLINE")
inline fun assertBoolean(value:Boolean, noinline message: (() -> String) = {"assertBoolean value is false"}){
    if(BuildConfig.DEBUG && !value){
        throw IllegalArgumentException(message())
    }
}



fun fixInputMethodManagerLeak(context: Context) {
    try {
        // 对 mCurRootView mServedView mNextServedView 进行置空...
        val imm: InputMethodManager =
            context.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager

        // author:sodino mail:sodino@qq.com
        var objGet: Any?
        val fMcurrootview = imm.javaClass.getDeclaredField("mCurRootView")
        val fMservedview = imm.javaClass.getDeclaredField("mServedView")
        val fMnextservedview = imm.javaClass.getDeclaredField("mNextServedView")

        if (fMcurrootview.isAccessible) {
            fMcurrootview.isAccessible = true
        }
        objGet = fMcurrootview.get(imm)
        if (objGet != null) { // 不为null则置为空
            fMcurrootview.set(imm, null);
        }

        if (!fMservedview.isAccessible) {
            fMservedview.isAccessible = true;
        }
        objGet = fMservedview.get(imm);
        if (objGet != null) { // 不为null则置为空
            fMservedview.set(imm, null);
        }

        if (!fMnextservedview.isAccessible) {
            fMnextservedview.isAccessible = true;
        }
        objGet = fMnextservedview.get(imm);
        if (objGet != null) { // 不为null则置为空
            fMnextservedview.set(imm, null);
        }
    } catch (t: Throwable) {
        t.printStackTrace()
    }

}


public fun <T> lazyNotSafe(initializer: () -> T): Lazy<T> {
    return lazy(LazyThreadSafetyMode.NONE, initializer)
}


