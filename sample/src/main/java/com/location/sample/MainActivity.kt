package com.location.sample

import android.annotation.SuppressLint
import android.os.*
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.HandlerCompat
import okhttp3.OkHttpClient
import java.lang.RuntimeException
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    companion object{
        private const val MSG_LOGIN  = 0x001
        private const val HANDLER_TAG = "HandlerTest"
    }
    private var msgIndex = 0
    private var msgAsyncIndex = 0
    private var looper:Looper? = null
    private var handler:Handler? = null
    private var asyncHandler:Handler? = null
    private var token:Int = -1

    private var handlerCallback: Handler.Callback = Handler.Callback {
        Log.d(HANDLER_TAG,"收到同步消息 what=${it.what} msg=${it.obj}")
        true
    }

    private val asyncCallback: Handler.Callback = Handler.Callback {
        Log.d(HANDLER_TAG,"收到异步消息 what=${it.what} msg=${it.obj}")
        true
    }
    @SuppressLint("DiscouragedPrivateApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_handler_test)

        Thread(Runnable {
            Looper.prepare()
            looper = Looper.myLooper()
            Looper.loop()
            throw RuntimeException("looper quit")
        }).start()


    }

    fun createHandler(v: View){
        looper?.let {
            //立即
            handler = Handler(it,handlerCallback)
            //延迟1ms
            asyncHandler = HandlerCompat.createAsync(it,asyncCallback)
            Log.d("HandlerTest","create handler success ")
        }
    }

    fun sendMessage(v: View){
        handler?.let {
            val what = msgIndex++
            Log.d(HANDLER_TAG,"发送同步消息 有消息屏障会阻塞 what=$what")
            it.obtainMessage(what,"同步消息").sendToTarget()
        }
    }
    fun sendAsyncMessage(v: View){
        asyncHandler?.let {
            val what = msgAsyncIndex++
            Log.d(HANDLER_TAG,"发送异步消息 可跳过消息屏障 what=$what")
            it.obtainMessage(what,"异步消息").sendToTarget()
        }
    }

    fun openSyncBarrier(v:View){
        looper?.let {
            postSyncBarrier(it)
            Log.d(HANDLER_TAG,"开启消息屏障 token=${token}")
        }
    }
    fun closeSyncBarrier(v:View){
        looper?.let {
            removeSyncBarrier(it)
            Log.d(HANDLER_TAG,"关闭消息屏障")
        }
    }

    @SuppressLint("DiscouragedPrivateApi")
    fun postSyncBarrier(looper: Looper){
        if(token >= 0){
            Log.d(HANDLER_TAG,"禁止重复开启消息屏障")
        }
        val declaredMethod =
            looper.queue::class.java.getDeclaredMethod("postSyncBarrier")
        declaredMethod.isAccessible  = true
        token = declaredMethod.invoke(looper.queue) as Int
    }

    fun removeSyncBarrier(looper: Looper){
        if(token < 0){
            Log.d(HANDLER_TAG,"消息屏障未开启")
        }
        val declaredMethod =
            looper.queue::class.java.getDeclaredMethod("removeSyncBarrier",Int::class.java)
         declaredMethod.isAccessible  = true
         declaredMethod.invoke(looper.queue,token)
        token = -1
    }
}

class MyHandler(looper: Looper):Handler(looper){
    override fun handleMessage(msg: Message) {
        //处理消息
//        OkHttpClient
    }

}

//class MainHandlerThread : Thread() {
//    override fun run() {
//        Looper.prepare()
//
//    }
//
//}