package com.location.wanandroid.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 *
 * @author tianxiaolong
 * time：2021/3/6 5:48 PM
 * description：
 * 所有列表接口的基类
 */
@JsonClass(generateAdapter = true)
data class PageData<T>(
    @Json(name = "curPage")
    val curPage: Int,
    @Json(name = "datas")
    val datas: List<T>,
    @Json(name = "offset")
    val offset: Int,
    @Json(name = "over")
    val over: Boolean,
    @Json(name = "pageCount")
    val pageCount: Int,
    @Json(name = "size")
    val size: Int,
    @Json(name = "total")
    val total: Int
)