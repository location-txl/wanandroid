package com.location.network.response

/**
 *
 * @author tianxiaolong
 * time：2021/1/31 3:35 PM
 * description：
 */
interface BaseResponse<out T> {
    fun isSuccess():Boolean
    val code:Int
    val data:T?
    val msg:String
}

