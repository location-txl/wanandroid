package com.location.wanandroid.http.cookie

import android.content.Context
import android.content.SharedPreferences
import android.text.TextUtils
import com.location.wanandroid.appContext
import okhttp3.Cookie
import okhttp3.HttpUrl
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.util.*
import java.util.concurrent.ConcurrentHashMap
import kotlin.collections.ArrayList
import kotlin.experimental.and


/**
 *
 * 项目名称: WanAndroid
 * 类描述:保存cookie工具类
 * 创建人: 田晓龙
 * 创建时间: 2018/4/6 0006 22:43
 * 修改人:
 * 修改内容:
 * 修改时间:
 */


class SaveCookieUtils {
    /**
     * 首先延迟初始化
     * 使用ConcurrentHashMap  避免多线程并发
     */
    val cookies: HashMap<String, ConcurrentHashMap<String, Cookie>> by lazy {
        HashMap<String, ConcurrentHashMap<String, Cookie>>()
    }

    var sharedPreferences: SharedPreferences
    val COOKIE_SP_NAME = "WanAndroid_cookie"

    init {
        sharedPreferences = appContext.getSharedPreferences(COOKIE_SP_NAME, Context.MODE_PRIVATE)
        val all = sharedPreferences.all
        for ((key, value) in all) {
            val split = TextUtils.split(value as String, ",")
            for (item in split) {
                val encodeCookie = sharedPreferences.getString(item, null)
                if (encodeCookie != null) {
                    val decodeCookie = decodeCookie(encodeCookie)
                    if (decodeCookie != null) {
                        if (!cookies.containsKey(key)) {
                            cookies.put(key, ConcurrentHashMap<String, Cookie>())
                        }
                        cookies.get(key)!!.put(item, decodeCookie)
                    }
                }
            }
        }

    }


    private fun getCookieToken(cookie: Cookie) = cookie.name() + "@" + cookie.domain()

    fun add(url: HttpUrl, cookie: Cookie) {
        val name = getCookieToken(cookie)
        /**
         * 是否过期
         */
        if (!cookie.persistent()) {
            if (!cookies.containsKey(url.host())) {
                cookies.put(url.host(), ConcurrentHashMap(10))
            }
            cookies.get(url.host())!!.put(name, cookie)
        } else {
            if (cookies.containsKey(url.host())) {
                cookies.get(url.host())!!.remove(name)
            }
        }


        /**
         *存到本地
         */
        sharedPreferences.edit().apply {
            putString(url.host(), TextUtils.join(",", cookies.get(url.host())!!.entries))
            putString(name, encodeCookie(Twat(cookie)))
        }.apply()


    }

    fun get(url: HttpUrl): MutableList<Cookie> {
        var list = ArrayList<Cookie>()
        if (cookies.containsKey(url.host())) {
            list.addAll(cookies.get(url.host())!!.values)
        }
        return list
    }

    fun removeAll() = {
        sharedPreferences.edit().apply {
            clear()
            clear()
        }
        cookies.clear()
    }

    fun remobe(url: HttpUrl, cookie: Cookie): Boolean {
        var name = getCookieToken(cookie)
        if (cookies.containsKey(url.host()) && cookies.get(url.host())!!.containsKey(name)) {
            cookies.get(url.host())!!.remove(name)
            sharedPreferences.edit().run {
                if (sharedPreferences.contains(name)) remove(name)
                putString(url.host(), TextUtils.join(",", cookies.get(url.host())!!.keys))
                apply()
            }
            return true

        } else {
            return false
        }
    }

    fun getCookies(): List<Cookie> {
        val list = ArrayList<Cookie>()
        for ((key, value) in cookies) {
            list.addAll(cookies.get(key)!!.values)
        }
        return list
    }

    /**
     * cookie序列化成String
     */
    fun encodeCookie(cookie: Twat): String? {
        if (cookie == null) return null
        var byteArrayOutputStream = ByteArrayOutputStream()
        var objectOutPutStream = ObjectOutputStream(byteArrayOutputStream)
        objectOutPutStream.writeObject(cookie)
        return byteArrayToHexString(byteArrayOutputStream.toByteArray())
    }


    /**
     * 将字符串转化为cookie
     */
    fun decodeCookie(message: String): Cookie {
        var hexStringToByteArray = hexStringToByteArray(message)
        val byteArryInputStream = ByteArrayInputStream(hexStringToByteArray)
        var cookie: Cookie? = null
        val objectInputStream = ObjectInputStream(byteArryInputStream)
        val okhttpCookie = objectInputStream.readObject() as Twat
//        cookie = if (okhttpCookie.clientCookies != null) okhttpCookie.clientCookies else okhttpCookie.cookies
        cookie =okhttpCookie.cookies
        return cookie!!
    }


    /**
     * 16进制字符串转二进制数组
     */
    fun hexStringToByteArray(message: String): ByteArray {
        val length = message.length
        /**
         * 设置Byte数组 长度为 message的一半
         */
        var data = ByteArray(length / 2)
        for (i in 0 until length step 2) {
            data[i / 2] = ((Character.digit(message[i], 16) shl 4) + Character.digit(message[i + 1], 16)) as Byte
        }
        return data
    }

    /**
     * 二进制转成16进制字符串
     */
    fun byteArrayToHexString(bytes: ByteArray): String {
        val builder = StringBuilder()
        for (byte in bytes) {
            /**
             * 相当于 java的 byte & 0x00f
             */
            var v = byte and 0x00f
            if (v < 16) builder.append('0')

            builder.append(Integer.toHexString(v.toInt()))


        }

        return builder.toString().toUpperCase(Locale.US)
    }


}