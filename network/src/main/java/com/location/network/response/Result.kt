package com.location.network.response

import java.lang.Exception

/**
 *
 * @author tianxiaolong
 * time：2021/1/31 3:03 PM
 * description：
 * 密封类
 * 处理网络请求是否处理成功
 */

sealed class Result<out T> {
    fun isSuccess(): Boolean = this is Success
    fun isFail(): Boolean = this is Fail
    data class Success<out T>(val outData: T?) : Result<T>(){
        val data:T
        get() = outData!!
    }
    data class Fail(val error: Exception, val code: Int = -1) : Result<Nothing>()
}



