package com.location.wanandroid.test

import com.location.base.logDebug
import com.location.wanandroid.RetrofitUtils
import com.location.wanandroid.http.UserService
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 *
 * @author tianxiaolong
 * time：2021/3/20 8:39 PM
 * description：
 */
class Test {
    val userService = RetrofitUtils.create(UserService::class.java)

    fun testRetrofitCall(){
        userService.loginForCall("xxx","xxx").enqueue(object : Callback<ResponseBody>{
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                TODO("Not yet implemented")
                val string = response.body()!!.string()
            }

        })
    }

    fun testRetrofitRxJava() {

        userService.loginForRxJava("xxx", "xxx")
            .subscribe { it ->
                logDebug(msg = "body=${it.string()}")
            }
    }
}