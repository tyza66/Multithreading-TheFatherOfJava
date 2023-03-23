package Class24;

public class Class24 {
    /*
        Lock锁与synchroized锁的区别
        sdk1.5更新的ReentrantLock类同样可以达到效果，而且比synchroized锁更加灵活
        synchroized属于jdk的关键字 底层属于c++虚拟机实现好的
        Lock的底层是基于AQS实现好的
        jdk版本在6以上 推荐使用synchroized锁
        synchroized锁的底层原理里面会有一个锁的升级过程 这些过程在jdk6进行了优化
        1.8版本优化的synchroized锁非常不错
        不懂原理的普通程序员直接使用Lock锁会出现 会直接变为重量级锁的情况 也就是说当前线程如果没获得到锁就会直接变成阻塞状态
        如果使用的是synchroized锁那么没获取到的时候就会重试多次获取，还没获取的话才会变重量级锁
        Lock本质是java并发编程里面的
    */
}
