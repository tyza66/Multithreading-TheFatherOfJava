package Class18;

public class Class18 {
    /*
        join方法
        可以实现多线程在底层时候的优先级
        可以实现某个线程先执行
        其实它的底层就是通过wait和notify封装的
        回顾一下wait和notify
        wait和notify必须结合synchronized使用
        底层JUC并发包里面会分成很多的集合
        但是底层不是java代码 而是虚拟机代码
        当前有线程调用了wait方法，当前的线程就会主动释放掉cpu执行权 当前线程就会放进一个集合里面 这个集合就叫做waitset集合
        waitset集合里面存放的就是wait了的线程 现在一旦调用了一下notify，就会唤醒线程
        唤醒的这个线程就会重新进入到获取锁的一个流程 entrylist
        这些东西似乎有点超纲了
        用synchronized的代码段多个线程去抢一个锁，抢到锁的线程才能去执行
        如果没有抢到这个锁，他是会有一个锁的升级过程的
        没有抢到锁的线程存放在blockedThreads 他的集合名称叫entrylist
    */
}
