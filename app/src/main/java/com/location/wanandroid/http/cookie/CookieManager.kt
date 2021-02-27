package com.location.wanandroid.http.cookie

import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl

/**
 *
 * 项目名称: WanAndroid
 * 类描述:Cookie管理类
 * 创建人: 田晓龙
 * 创建时间: 2018/4/6 0006 22:40
 * 修改人:
 * 修改内容:
 * 修改时间:
 */


 class CookieManager :CookieJar {
  companion object {
      val saveCookieUtils = SaveCookieUtils()
  }
    /**
     * 保存cookie
     */
    override fun saveFromResponse(url: HttpUrl?, cookies: MutableList<Cookie>?) {
        if(cookies!!.size>0){
           for(cookie in cookies){
               saveCookieUtils.add(url!!,cookie)
           }
        }
    }

    override fun loadForRequest(url: HttpUrl?): MutableList<Cookie> {

        return saveCookieUtils.get(url!!)
    }

    fun clearAllCookies()  = saveCookieUtils.removeAll()
}