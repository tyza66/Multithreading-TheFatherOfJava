package Class32;

public class Class32 {
    /*
        纯手写日志框架和设计原理
        java之父说有点小蓝度
        日志框架很多编程语言都有 但是思想是一样的
        我们一般会在项目中去整合一些日志框架 做一些打印日志
        我们通常会加一些日志注解之后加上Log.info 就可以讲日志输出到本地
        他的底层也是使用的多线程的技术
        如果不使用多线程其实会有很多的bug的 不好使的
        如果不适用多线程的话：
            1.获取想打印的日志
            2.讲日志写入到磁盘里
        这样写肯定会出现很多的bug 如果打印多次 就会写多个日志到磁盘中 这段代码就会执行很多次
        当这些日志全都写入了磁盘中之后才执行业务代码 这样话 影响运行效率甚至影响到接口的吞吐量 所以日志框架中写入磁盘中一定是一个异步的过程
        比如我们使用log.info() 的时候本质就是将当前的日志缓存到队列中
        再使用一个线程再异步取出当前的日志写入磁盘中
    */
}
