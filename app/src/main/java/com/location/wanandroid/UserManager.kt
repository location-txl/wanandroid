package com.location.wanandroid

import android.text.TextUtils
import android.widget.Toast
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.createDataStore
import androidx.lifecycle.MutableLiveData
import com.location.base.getData
import com.location.base.livedata.Event
import com.location.base.logDebug
import com.location.wanandroid.data.UserData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.RuntimeException
import java.util.prefs.Preferences

/**
 *
 * @author tianxiaolong
 * time：2021/2/27 3:56 PM
 * description：
 */
object UserManager {
    private const val TAG = "UserManager"
    private const val NAME = "user_info"

    val userState = object : MutableLiveData<UserState>() {
        override fun onActive() {
            logDebug(TAG, "onActive")
        }

        override fun onInactive() {
            value = UserState.INVALID
            logDebug(TAG, "onInactive")
        }
    }

    /**
     * 用户名
     */
    private val USER_NAME = stringPreferencesKey("user_name")

    /**
     * 不保存用户密码
     */
    @Deprecated(message = "不保存用户密码")
    private val USER_PWD = stringPreferencesKey("user_pwd")
    private val USER_IS_LOGIN = booleanPreferencesKey("user_is_login")
    private val USER_ID = intPreferencesKey("user_id")
    private val USER_HEAD = stringPreferencesKey("user_icon")
    private val userDataStore by lazy { appContext.createDataStore(name = NAME) }


    private fun setUserState(state: UserState) {
        userState.postValue(state)
    }

    suspend fun saveUserInfo(data: UserData) {
        userDataStore.edit {
            it[USER_ID] = data.id
            it[USER_NAME] = data.username
            it[USER_HEAD] = data.icon
            it[USER_IS_LOGIN] = true
        }
        setUserState(UserState.LOGIN)
    }

    suspend fun readUserName(): String? {
        val data = userDataStore.getData(USER_NAME, "")
        return if (TextUtils.isEmpty(data)) {
            null
        } else {
            data
        }
    }

    @Deprecated(message = "不保存用户密码")
    suspend fun readUserPwd(): String? {
        val data = userDataStore.getData(USER_PWD, "")
        return if (TextUtils.isEmpty(data)) {
            null
        } else {
            data
        }
    }

    suspend fun isLogin(): Boolean {
        return userDataStore.getData(USER_IS_LOGIN, false)
    }

    suspend fun readUserId(): Int {
        if (!isLogin()) {
            throw RuntimeException("not login user after login imoke")
        }
        return userDataStore.getData(USER_ID, 0)
    }

    suspend fun readUserHead(): String {
        return userDataStore.getData(USER_HEAD, "")
    }

    suspend fun clearLogin() {
        userDataStore.edit {
            it[USER_ID] = 0
            it[USER_NAME] = ""
            it[USER_HEAD] = ""
            it[USER_IS_LOGIN] = false
            logDebug(TAG, "set logout")
        }
        setUserState(UserState.LOGOUT)
    }


}

enum class UserState {
    LOGIN,
    LOGOUT,
    INVALID
}
