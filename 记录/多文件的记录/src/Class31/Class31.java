package Class31;

public class Class31 {
    /*
        Callable与FutureTask的底层实现原理
        之前我们演示中ThreadCallable实现了Callable接口
        正常的线程是没有返回结果的 但是我们需要拿到异步执行的访问结果 所以使用实现Callable
        面试官有时候会问线程怎么异步返回值 我们只要回答使用Callable和FutureTask模式就行了
        我们需要建立一个FutureTask并且把我们的Callable传递给我们的FutureTask
        之后再讲FutureTask交给我们的Thread线程执行
        之后我们一旦调用了FutureTask的get方法，主线程就会阻塞等待子线程执行完毕拿到子线程的返回值
        这个代码有两种实现方式 loadSupport第二种是使用wait和notify
        我们可以自己实现一个Callable
        FutureTask能被Thread执行，是因为他实现了Runnable接口
        我们也要自己写一个FutureTask
    */
}
