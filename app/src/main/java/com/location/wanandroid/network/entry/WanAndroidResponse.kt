package com.location.androidsample.wanandroid.entry

import kotlinx.serialization.Serializable

@Serializable
data class WanAndroidResponse<T>(
    val data: T,
    val errorCode: Int,
    val errorMsg: String
){
    val success: Boolean
        get() = errorCode == 0
}