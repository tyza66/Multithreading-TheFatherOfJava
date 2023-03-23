package Class24;

import java.util.concurrent.ConcurrentHashMap;

public class Thread09_1 extends Thread {
    //使用volatile关键字 保证线程可见性 不加的话子线程不会自己终止
    public volatile boolean isStart = true;
    @Override
    public void run() {
        while (isStart) {
            /*if(this.isInterrupted()){
                break;
            }*/
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread09_1 thread09 = new Thread09_1();
        thread09.start();
        //为了看子线程中断的效果 我们等三秒
        Thread.sleep(3000);
        //中断阻塞或者运行的线程
        System.out.println("中断子线程");
        thread09.isStart = false;
        //在1.7和1.8版本有很大区别 在1.7版本是使用的Lock锁保证线程安全 在1.8版本是直接使用synchroized锁保证线程安全
        new ConcurrentHashMap<>();
    }
}
