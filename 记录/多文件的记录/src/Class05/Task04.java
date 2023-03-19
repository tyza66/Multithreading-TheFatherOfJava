package Class05;

import java.util.concurrent.locks.LockSupport;

public class Task04 {
    //juc并发中
    public static void main(String[] args) throws InterruptedException {
        Thread thread01= new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是子线程开始");
                LockSupport.park();
                System.out.println("我是子线程结束");
            }
        });
        thread01.start();
        Thread.sleep(3000);
        LockSupport.unpark(thread01);
    }
}
