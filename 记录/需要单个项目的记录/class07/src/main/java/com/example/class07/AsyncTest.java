package com.example.class07;

import org.springframework.scheduling.annotation.Async;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;


@Component
public class AsyncTest {
    @Async
    public void asyncLog() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("<2>");
    }
}
