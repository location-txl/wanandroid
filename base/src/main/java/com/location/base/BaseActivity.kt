package com.location.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe

class BaseActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        StatusManager.loadingLiveData.observe(this){
                    when(it){
                        LoadingStatus.SHOW_LOADING -> {

                        }
                        LoadingStatus.HIDE_LOADING -> {

                        }
                        else -> {

                        }
                    }
        }
    }




}