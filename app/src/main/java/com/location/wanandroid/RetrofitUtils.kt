package com.location.wanandroid

import com.location.wanandroid.http.cookie.CookieManager
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitUtils {
    private const val BASE_URL = "https://wanandroid.com/"
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .run {
                addConverterFactory(MoshiConverterFactory.create())
                baseUrl(BASE_URL)
                    .client(
                        OkHttpClient.Builder()
                            .cookieJar(CookieManager()).build()
                    )
                build()
            }

    }


    fun <T> create(clazz: Class<T>): T = retrofit.create(clazz)
}