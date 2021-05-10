package com.location.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.observe
import com.location.base.delegate.DaggerActivityDelegate
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity(){


    abstract val layoutId: Int

    private val TAG = "ActivityEvent-${javaClass.simpleName}"


    protected val binding: T by lazy {
        DataBindingUtil.setContentView<T>(
            this, layoutId
        )
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logDebug(TAG,"onCreate")
        binding.lifecycleOwner = this
        init()
    }
    override fun onStart() {
        super.onStart()
        logDebug(TAG,"onStart")
    }

    override fun onResume() {
        super.onResume()
        logDebug(TAG,"onResume")
    }

    override fun onPause() {
        super.onPause()
        logDebug(TAG,"onPause")
    }

    override fun onStop() {
        super.onStop()
        logDebug(TAG,"onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        logDebug(TAG,"onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        logDebug(TAG,"onRestart")
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        logDebug(TAG,"onSaveInstanceState bundle outPersistentState")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        logDebug(TAG,"onSaveInstanceState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        logDebug(TAG,"onRestoreInstanceState")
    }

    private fun init(){
        StatusManager.loadingLiveData.observe(this) {
            when (it) {
                LoadingStatus.SHOW_LOADING -> {

                }
                LoadingStatus.HIDE_LOADING -> {

                }
                else -> {

                }
            }
        }
    }

    protected fun showDialLog() {

    }

    protected fun hideDialog() {

    }






}