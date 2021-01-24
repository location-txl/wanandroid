package com.location.wanandroid

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitUtils {
    private  const val  BASE_URL = "https://wanandroid.com/"
      val retrofit by lazy { Retrofit.Builder()
        .run {
            addConverterFactory(MoshiConverterFactory.create())
            baseUrl(BASE_URL)
            build()
        }

    }



    fun <T> create(clazz:Class<T>):T = retrofit.create(clazz)
}