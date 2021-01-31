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

suspend fun <T> BaseRepository.excutResponse(response: BaseResponse<T>):Result<T>{
    return  coroutineScope{
        if(response.isSuccess()){
            Result.Success(response.data!!)
        }else{
            Result.Fail(IOException(response.msg))
        }
    }
}

suspend fun <T> BaseRepository.safeCall(block:suspend () -> Result<T>):Result<T>{
    return try {
        block()
    }catch (e:Exception) {
        Result.Fail(e)
    }
}

interface BaseRepository