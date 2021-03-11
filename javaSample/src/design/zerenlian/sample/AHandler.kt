package design.zerenlian.sample

import design.zerenlian.Handler
import design.zerenlian.Request
import design.zerenlian.Response

class AHandler: Handler() {
    override fun handlerEvent(request: Request): Response? {
        println("Test Handler ${hashCode()}")
        if(request.code <100){
            return Response("params=[${request.params}] ${javaClass.simpleName} 已经处理")
        }else{
            request.params+="|${javaClass.simpleName}"
        }
        return next?.handlerEvent(request)
    }
}