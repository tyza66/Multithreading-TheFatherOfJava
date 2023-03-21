package com.example.class14;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//我们把当前的Bean对象设置成原型 这个对象就是多例 每个访问都是一个独立的的了 就不会出现之前需要等待的现象
//并且多例中每个bean对象有独立的count元素
@Scope(value = "prototype")
public class CountServer {
    private int count = 0;

    @RequestMapping("/count")
    public synchronized String count() throws InterruptedException {
        System.out.println("count:"+count++);
        Thread.sleep(3000);
        return "count";
    }
}
