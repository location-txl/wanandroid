package com.location.network.factory

import androidx.lifecycle.LiveData
import com.location.network.response.Result
import retrofit2.*
import java.io.IOException
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 *
 * @author tianxiaolong
 * time：2021/3/20 5:09 PM
 * description：
 */
class LiveDataCallAdapterFactory private constructor(private val autoCancel: Boolean = false) :
    CallAdapter.Factory() {

    companion object {
        fun create(autoCancel: Boolean = false): LiveDataCallAdapterFactory {
            return LiveDataCallAdapterFactory(autoCancel)
        }
    }


    override fun get(
        returnType: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {
        val rawType = getRawType(returnType)
        if (rawType != HttpLiveData::class.java) {
            return null
        }
        val type = getParameterUpperBound(0, returnType as ParameterizedType)
        return object : CallAdapter<Any, LiveData<*>> {
            override fun adapt(call: Call<Any>): LiveData<*> {
                return LiveDataCallAdapter(call, autoCancel)
            }

            override fun responseType(): Type {
                return type
            }

        }
    }


    class LiveDataCallAdapter<T>(private val delegate: Call<T>, private val autoCancel:Boolean) :
        HttpLiveData<T>() {
        override fun onActive() {
            super.onActive()
            if (!delegate.isExecuted) {
                delegate.enqueue(object : Callback<T> {
                    override fun onFailure(call: Call<T>, t: Throwable) {
                        postValue(Result.Fail(IOException(t.message)))

                    }

                    override fun onResponse(call: Call<T>, response: Response<T>) {
                        postValue(Result.Success(response.body()))
                    }

                })
            }
        }

        override fun onInactive() {
            super.onInactive()
            if (autoCancel) {
                cancel()
            }
        }

        override fun cancel() {
            delegate.cancel()
        }

        override fun clone(): HttpLiveData<T> {
            return LiveDataCallAdapter(delegate.clone(),autoCancel)
        }
    }

}

abstract class HttpLiveData<T> : LiveData<Result<T>>() {
    abstract fun cancel()

    abstract fun clone(): HttpLiveData<T>
}
