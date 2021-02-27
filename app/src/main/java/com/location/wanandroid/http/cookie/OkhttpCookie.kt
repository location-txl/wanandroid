package com.location.wanandroid.http.cookie

import android.os.Parcel
import android.os.Parcelable
import okhttp3.Cookie

/**
 *
 * 项目名称: WanAndroid
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2018/4/7 0007 0:57
 * 修改人:
 * 修改内容:
 * 修改时间:
 */


data class OkhttpCookie(var cookies: Cookie?, var clientCookies: Cookie?) : Parcelable {
    constructor(cookies: Cookie) : this(cookies, null)

    val EMPTY = "empty"

    constructor(source: Parcel) : this(null,null) {

        //            source.readCookie(),
//            source.readCookie()
//            source.readValue(ClassLoader.getSystemClassLoader()) as Cookie,
//            source.readValue(ClassLoader.getSystemClassLoader()) as Cookie
        val name = source.readValue(ClassLoader.getSystemClassLoader()) as String
        val value = source.readValue(ClassLoader.getSystemClassLoader()) as String
        val expiresAt = source.readLong()
        val domain = source.readValue(ClassLoader.getSystemClassLoader()) as String
        val path = source.readValue(ClassLoader.getSystemClassLoader()) as String
        val secure = source.readValue(ClassLoader.getSystemClassLoader()) as Boolean
        val httpOnly = source.readValue(ClassLoader.getSystemClassLoader()) as Boolean
        val hostOnly = source.readValue(ClassLoader.getSystemClassLoader()) as Boolean
        var builder = Cookie.Builder()
        builder.name(name)
        builder.value(value)
        builder.expiresAt(expiresAt)
        builder = if (hostOnly) builder.hostOnlyDomain(domain) else builder.domain(domain)
        builder = builder.path(path)
        builder = if (secure) builder.secure() else builder
        builder = if (httpOnly) builder.httpOnly() else builder
        cookies = builder.build()
        clientCookies = builder.build()

    }




    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        //        writeValue(cookies)
//        writeValue(clientCookies)
        writeValue(cookies!!.name())
        writeValue(cookies!!.value())
        writeValue(cookies!!.expiresAt())
        writeValue(cookies!!.domain())
        writeValue(cookies!!.path())
        writeValue(cookies!!.secure())
        writeValue(cookies!!.httpOnly())
        writeValue(cookies!!.hostOnly())
        writeValue(cookies!!.persistent())
    }


    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<OkhttpCookie> = object : Parcelable.Creator<OkhttpCookie> {
            override fun createFromParcel(source: Parcel): OkhttpCookie = OkhttpCookie(source)
            override fun newArray(size: Int): Array<OkhttpCookie?> = arrayOfNulls(size)
        }
    }
}
