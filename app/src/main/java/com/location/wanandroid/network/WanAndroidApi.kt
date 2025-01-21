package com.location.wanandroid.network

import com.ihsanbal.logging.Level
import com.ihsanbal.logging.LoggingInterceptor
import com.location.androidsample.wanandroid.entry.ArticleResponse
import com.location.androidsample.wanandroid.entry.WanAndroidResponse
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface WanAndroidApi {
    @GET("article/list/{page}/json2")
    suspend fun getArticleList(@Path("page") page: Int): WanAndroidResponse<ArticleResponse>

}

val httpModules = module {
    single {
        Retrofit.Builder().baseUrl("https://www.wanandroid.com/").addConverterFactory(
            Json.asConverterFactory(
                "application/json; charset=UTF8".toMediaType()
            )
        ).client(OkHttpClient.Builder().apply {
            addInterceptor(
                LoggingInterceptor.Builder().setLevel(Level.HEADERS).build()
            )
        }.build()).build().create<WanAndroidApi>(WanAndroidApi::class.java)
    } bind WanAndroidApi::class
}

