package com.example.class07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    AsyncTest at = new AsyncTest();
    @GetMapping("/test1")
    public int test1() throws InterruptedException {
        System.out.println("<1>");
        at.asyncLog();
        System.out.println("<3>");
        return 3;
    }
}
