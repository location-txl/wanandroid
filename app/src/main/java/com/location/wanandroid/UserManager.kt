package com.location.wanandroid

import android.text.TextUtils
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.createDataStore
import com.location.base.getData
import java.util.prefs.Preferences

/**
 *
 * @author tianxiaolong
 * time：2021/2/27 3:56 PM
 * description：
 */
object UserManager {
    private  const val  NAME = "user_info"

    private val USER_NAME = stringPreferencesKey("user_name")
    private val USER_PWD = stringPreferencesKey("user_pwd")
    private val USER_IS_LOGIN  = booleanPreferencesKey("user_is_login")
    private val userDataStore  by lazy { appContext.createDataStore( name = NAME) }


    suspend fun saveUserInfo(userName:String,userPwd:String){
        userDataStore.edit {
            it[USER_NAME] = userName
            it[USER_PWD] = userPwd
            it[USER_IS_LOGIN] = true
        }
    }

    suspend fun readUserName(): String? {
        val data = userDataStore.getData(USER_NAME, "")
        return if (TextUtils.isEmpty(data)) {
            null
        } else {
            data
        }
    }
    suspend fun readUserPwd(): String? {
        val data = userDataStore.getData(USER_PWD, "")
        return if (TextUtils.isEmpty(data)) {
            null
        } else {
            data
        }
    }

    suspend fun isLogin():Boolean{
        return  userDataStore.getData(USER_IS_LOGIN,false)
    }

}
