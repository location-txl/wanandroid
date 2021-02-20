package com.location.sample

import java.lang.ref.PhantomReference
import java.lang.ref.SoftReference
import java.lang.ref.WeakReference
data class User(val name:String)
fun main(){
    weakRefrenceDemo()
//    softRefrenceDemo()
}

private fun weakRefrenceDemo() {
    println("弱引用")
    val wekStr = WeakReference<User>(User("tom"))
    wekStr.get()?.let {
        println("name=${it.name}")
    }
    System.gc()
    if (wekStr.get() == null) {
        println("已经回收")
    } else {
        println("未回收")
    }
}
private fun softRefrenceDemo() {
    println("软引用")
    val wekStr = SoftReference<User>(User("tom"))
    wekStr.get()?.let {
        println("name=${it.name}")
    }
    System.gc()
    if (wekStr.get() == null) {
        println("已经回收")
    } else {
        println("未回收")
    }
}