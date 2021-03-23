package com.location.wanandroid.data

import com.location.base.BaseResponse
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 *
 * @author tianxiaolong
 * time：2021/1/31 2:02 PM
 * description：
 * WanAndroid 基础类
 * {
 * "errorCode":-1,
 * "errorMsg":"dsa"
 * "data":"密码错误"
 * }
 */
private const val ERROR_CODE_LEVEL = 0

@JsonClass(generateAdapter = true)
data class WanResponse<out T>(
    @Json(name = "errorCode")
    val errorCode: Int,
    @Json(name = "errorMsg")
    val errorMsg: String,
    @Json(name = "data")
    override val data: T?
) : BaseResponse<T> {
    override fun isSuccess() = errorCode >= ERROR_CODE_LEVEL

    override val code: Int
        get() = errorCode
    override val msg: String
        get() = errorMsg

}

