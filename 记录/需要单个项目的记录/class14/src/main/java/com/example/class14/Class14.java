package com.example.class14;

public class Class14 {
    /*
        在springMVC中Controller默认是单例的 需要注意线程安全问题
        单例原因有二：为了性能，不需要多例
        spring默认每个bean对象都是单例的，多利的话就浪费内存
        如果这些单例都同时访问一个方法 就造成了线程安全性问题

    */
}
