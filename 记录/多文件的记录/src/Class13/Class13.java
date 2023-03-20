package Class13;

public class Class13 {
    /*
        如何保证线程同步
        面试官问如何保证线程同步就是在问如何保证线程安全
        synchronized的意思就是锁
        回答就是synchronized
        如果要展示技术
        就可以把锁的升级过程展示出来
        偏向锁-》轻量级锁-》重量级锁
        轻量级锁底层用的就是CAS
        CAS是Compare-and-Swap的缩写，即比较并交换。它是一种并发编程中常用的算法，包含三个参数：V，A，B。其中，V表示要读写的内存位置，A表示旧的预期值，B表示新值。CAS指令执行时，当且仅当V的值等于预期值A时，才会将V的值设为B，如果V和A不同，说明已经有其他线程修改了V的值，此时CAS操作失败，不会执行任何操作。在Java中，CAS相关的实现是通过C++内联汇编的形式实现的，Java代码需通过JNI才能调用。
        JNI是Java Native Interface的缩写，它是Java和其他语言（主要是C和C++）之间的桥梁，提供了若干的API实现了Java和其他语言的通信。通俗来说，就是Java调用C/C++函数的接口。

        使用Lock锁 JUC并发包中的 底层是基于AQS+CAS实现的
    */
}
