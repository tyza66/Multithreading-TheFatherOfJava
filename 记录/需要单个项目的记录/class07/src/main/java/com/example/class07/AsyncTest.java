package com.example.class07;

import com.example.class07.annotation.MyAsync;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class AsyncTest {
    //@Async
    @MyAsync
    public void asyncLog() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("<2>");
    }

    @Bean
    public String getString(){
        return "123";
    }
}
