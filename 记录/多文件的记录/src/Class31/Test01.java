package Class31;

import java.util.concurrent.locks.LockSupport;

public class Test01 {
    public static void main(String[] args) {
        //阻塞当前线程
        //LockSupport.park();
        Thread t1 =  new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ",1");
                //阻塞当前线程
                LockSupport.park();
                System.out.println(Thread.currentThread().getName() + ",2");
            }
        });
        t1.start();
        //我们主线程三秒之后唤醒子线程继续向下执行
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LockSupport.unpark(t1);
    }
}
