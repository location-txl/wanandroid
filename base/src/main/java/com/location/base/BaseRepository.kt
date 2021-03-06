package com.location.base

import kotlinx.coroutines.coroutineScope
import java.io.IOException
import java.lang.Exception

/**
 *
 * @author tianxiaolong
 * time：2021/1/31 3:55 PM
 * description：
 */


suspend inline fun <T> excutResponse(response: BaseResponse<T>):Result<T>{
    return coroutineScope{
        if(response.isSuccess()){
            Result.Success(response.data)
        }else{
            Result.Fail(IOException(response.msg),response.code)
        }
    }
}

suspend fun <T> safeCall(block: suspend () -> Result<T>):Result<T>{
    return try {
        block()
    }catch (e:IOException) {
        logDebug(msg = "safe call error ${e.message}")
        Result.Fail(e)
    }
}
suspend fun <T> call(block: suspend () -> Result<T>):Result<T>{
        return block()
}

interface BaseRepository