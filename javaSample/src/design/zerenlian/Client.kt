package design.zerenlian

import javax.print.attribute.standard.NumberUp

/**
 * 客户端 负责组装责任链 并发送请求
 */
class Client {
    private var mHandler:Handler? = null

    @Synchronized
    fun addHandler(handler:Handler){
        if(mHandler == null){
            mHandler = handler
        }else{
            var currentHandler = mHandler!!
            while (currentHandler.next != null){
                currentHandler = currentHandler.next!!
            }
            currentHandler.next = handler
        }
    }
    @Synchronized
    fun getHandlerEvent(request: Request): Response? {
       return mHandler?.let {
             return@let it.handlerEvent(request)
        }
    }
}