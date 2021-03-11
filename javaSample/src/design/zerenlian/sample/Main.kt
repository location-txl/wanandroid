package design.zerenlian

import design.zerenlian.sample.AHandler
import design.zerenlian.sample.BHandler
import design.zerenlian.sample.CHandler

fun main() {
    val client = Client()
    client.addHandler(AHandler())
    client.addHandler(BHandler())
    client.addHandler(CHandler())
    val request = Request("apple",266)
    val handlerEvent = client.getHandlerEvent(request)
    handlerEvent?.let {
        println("response=$it")
    }

}