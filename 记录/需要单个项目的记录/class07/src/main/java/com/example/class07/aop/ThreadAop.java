package com.example.class07.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;

@Aspect
@Component
public class ThreadAop {

    @Around(value = "@annotation(com.example.class07.annotation.MyAsync)")
    public Object around(ProceedingJoinPoint joinPoint){
        try{
            System.out.println("环绕开始");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        joinPoint.proceed();
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }
                }
            }).start();
            System.out.println("环绕结束");
            return "环绕通知";
        } catch (Throwable throwable) {
            return "系统出错";
            //throwable.printStackTrace();
        }
    }
}
