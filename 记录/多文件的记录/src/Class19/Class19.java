package Class19;

public class Class19 {
    /*
        join的底层原理是如何实现的
        查看join的源码
        相当于用调用了this锁的wait阻塞
        例子中相当于t2调用了t1.wait() 主动释放t1的this锁 同时t2变成了阻塞状态
        t1执行完之后需要去唤醒t2 （t2正在等待）但是他这个唤醒不是在java层面做的
        虚拟机源码中会主动唤醒正在等待的线程
        join的底层使用的是wait封装的 唤醒代码在jvm hotspot源码中
        svm在关闭线程之前会检测线阻塞在t1线程对象上的线程，然后notifyAll，这t2就被唤醒了
    */
}
