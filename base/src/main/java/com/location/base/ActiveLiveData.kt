package com.location.base

import androidx.lifecycle.LiveData

class ActiveLiveData<T>:LiveData<T>() {
    private var active = false
    override fun postValue(value: T) {
        if(active){
            super.postValue(value)
        }
    }

    override fun setValue(value: T) {
        if(active){
            super.setValue(value)
        }

    }
    override fun onActive() {
        active = true
    }

    override fun onInactive() {
        active =false
    }
}