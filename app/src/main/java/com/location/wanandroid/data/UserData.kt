package com.location.wanandroid.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserData (
    @Json(name = "data")
    val data: Data,
    @Json(name = "errorCode")
    val errorCode: Int,
    @Json(name = "errorMsg")
    val errorMsg: String
)

@JsonClass(generateAdapter = true)
data class Data(
    @Json(name = "admin")
    val admin: Boolean,
    @Json(name = "chapterTops")
    val chapterTops: List<Any>,
    @Json(name = "coinCount")
    val coinCount: Int,
    @Json(name = "collectIds")
    val collectIds: List<Int>,
    @Json(name = "email")
    val email: String,
    @Json(name = "icon")
    val icon: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "nickname")
    val nickname: String,
    @Json(name = "password")
    val password: String,
    @Json(name = "publicName")
    val publicName: String,
    @Json(name = "token")
    val token: String,
    @Json(name = "type")
    val type: Int,
    @Json(name = "username")
    val username: String
)