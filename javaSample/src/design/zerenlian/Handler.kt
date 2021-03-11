package design.zerenlian

/**
 * 抽象处理者
 * 为一个单向链表 持有下一个链接
 */
abstract class Handler {
    internal var next:Handler? = null
    get() = field
    abstract fun handlerEvent(request:Request):Response?;
}

