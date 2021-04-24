package com.location.network

import com.location.base.logDebug
import com.location.network.response.BaseResponse
import com.location.network.response.Result
import kotlinx.coroutines.coroutineScope
import java.io.IOException

/**
 *
 * @author tianxiaolong
 * time：2021/3/26 11:58 PM
 * description：
 */

/**
 * 执行请求返回结果
 * @param response BaseResponse<T>
 * @return Result<T>
 * @exception IOException
 */
suspend inline fun <T> executeResponse(response: BaseResponse<T>): Result<T> {
    return coroutineScope{
        if(response.isSuccess()){
            Result.Success(response.data)
        }else{
            Result.Fail(IOException(response.msg),response.code)
        }
    }
}

/**
 * 执行安全的响应块返回Result
 * @param block SuspendFunction0<Result<T>>
 * @return Result<T>
 */
suspend fun <T> safeCall(block: suspend () -> Result<T>): Result<T> {
    return try {
        block()
    }catch (e: IOException) {
        logDebug(msg = "safe call error ${e.message}")
        Result.Fail(e)
    }
}


/**
 * 执行响应快 返回Result
 * @param block SuspendFunction0<Result<T>>
 * @return Result<T>
 */
suspend fun <T> call(block: suspend () -> Result<T>): Result<T> {
    return block()
}