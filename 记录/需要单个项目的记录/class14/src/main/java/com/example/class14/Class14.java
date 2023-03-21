package com.example.class14;

public class Class14 {
    /*
        在springMVC中Controller默认是单例的 需要注意线程安全问题
        单例原因有二：为了性能，不需要多例
        spring默认每个bean对象都是单例的，多利的话就浪费内存
        如果这些单例都同时访问一个方法 就造成了线程安全性问题
        多个窗口访问controller接口的时候，如果接口方法使用了synchronized锁，那么这个接口就会变成单线程的，影响了其他访问的效率
        所以不要把整个controller方法整体加上一个synchronized锁而是在局部的需要线程安全同步的的代码块加上锁
        这就是在整体的效率上的问题了
    */
}
