package com.location.network.response

/**
 *
 * @author tianxiaolong
 * time：2021/1/31 3:35 PM
 * description 请求接口基类
 * @param code 服务器返回的code码
 * @param msg  服务器返回的消息
 * @param data 服务器返回的实体类
 *
 */
interface BaseResponse<out T> {
    /**
     * 是否请求成功
     */
    fun isSuccess():Boolean
    val code:Int
    val data:T?
    val msg:String
}

