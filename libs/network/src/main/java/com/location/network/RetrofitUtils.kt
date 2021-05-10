package com.location.network

import android.content.Context
import com.franmontiel.persistentcookiejar.PersistentCookieJar
import com.franmontiel.persistentcookiejar.cache.SetCookieCache
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor
import com.location.base.BuildConfig
import com.location.base.logDebug
import com.location.network.factory.LiveDataCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.*
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitUtils {
    private const val BASE_URL = "https://wanandroid.com/"

    internal var context: Context? = null

    fun initContext(appContext:Context){
        context = appContext.applicationContext
    }

    private val cookieManager by lazy {
        if(context == null){
            throw IllegalArgumentException("Retrofit context is null you need init context")
        }
        PersistentCookieJar(
            SetCookieCache(), SharedPrefsCookiePersistor(
                context
            )
        )
    }

    private fun OkHttpClient.addDebugConfig(): OkHttpClient {
        return if (BuildConfig.DEBUG)
            this.newBuilder().addNetworkInterceptor(HttpLoggingInterceptor(HttpLog()).apply {
                level = HttpLoggingInterceptor.Level.BASIC
            })
                .addNetworkInterceptor {
                    httpRequestCount()
                    it.proceed(it.request())
                }
                .build()
        else
            this
    }

    private fun createClient():OkHttpClient = OkHttpClient.Builder()
        .cookieJar(cookieManager)
        .build()

    private val retrofit: Retrofit by lazy {

        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory.create(true))
            .validateEagerly(BuildConfig.DEBUG)
            .baseUrl(BASE_URL)
            .client(createClient().addDebugConfig())
            .build()


    }


    fun <T> create(clazz: Class<T>): T = retrofit.create(clazz)

    /**
     * 清除cookie
     */
    fun clearCookie(){
        cookieManager.clear()
        cookieManager.clearSession()
    }
}
var count = 0

private fun httpRequestCount(){
    count++
    logDebug("HttpLog", "request_count=$count")
}
private class HttpLog : HttpLoggingInterceptor.Logger {
    override fun log(message: String?) {
        message?.let {

            logDebug("HttpLog", it)
        }
    }

}






