package com.location.wanandroid.network

import android.util.Log.d
import android.util.Log.e
import com.location.androidsample.wanandroid.entry.WanAndroidResponse
import kotlinx.coroutines.CancellationException
import retrofit2.HttpException

sealed class Result<T> {

    data class Success<T>(val data: T) : Result<T>()

    data class Error<T>(val throwable: Throwable) : Result<T>()

    data class Fail<T>(val message: String, val code: Int, val httpFail: Boolean) : Result<T>()
}

inline fun <T> WanAndroidApi.execute(block: WanAndroidApi.() -> WanAndroidResponse<T>): Result<T> =
    try {
        val r = block()
        if (r.success) {
            Result.Success(r.data)
        } else {
            Result.Fail(r.errorMsg, r.errorCode, false)
        }
    } catch (e: HttpException) {
        Result.Fail(e.message(), e.code(), true)
    } catch (e: CancellationException) {
        throw e
    } catch (e: Exception) {
        e.printStackTrace()
        Result.Error(e)
    }