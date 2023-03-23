package Class28;

public class Class28 {
    /*
        join/wait与sleep之间的不同
        面试笔试题会经常考到
        他们都可以让我们的线程从运行状态变成等待状态
        但是他们的区别是很大的 join是基于wait封装的
        wait方法会释放状态锁 而sleep方法不会释放状态锁
        区别：
            sleep方法在睡眠的时候不会释放锁
            join方法先执行另外一个线程 在等待过程中释放对象锁
            wait方法在等待的过程中释放对象锁 需要在synchronized锁中使用
    */
}
