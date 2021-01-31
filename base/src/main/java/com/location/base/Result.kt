package com.location.base

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
    data class Success<out T>(val data: T) : Result<T>()
    data class Fail(val error: Exception, val code: Int = -1) : Result<Nothing>()
}

inline fun <T> Result<T>.parseResult(
    success: (data: T) -> Unit,
    errorBlock: (code: Int, msg: String) -> Unit
) {
    when (this) {
        is Result.Success -> success(data)
        is Result.Fail -> errorBlock(code, error.message!!)
    }
}

