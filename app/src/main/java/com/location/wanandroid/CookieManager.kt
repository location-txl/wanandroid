package com.location.wanandroid

import android.text.TextUtils
import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl

class CookieManager:CookieJar {
    override fun saveFromResponse(url: HttpUrl, cookies: MutableList<Cookie>) {
        TextUtils.join
    }

    override fun loadForRequest(url: HttpUrl): MutableList<Cookie> {
        return  mutableListOf()
    }
}