package Class25;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Thread10_1 {
    //可重用锁
    private Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread10_1 thread10 = new Thread10_1();
        thread10.print1();
        Thread.sleep(500);
        System.out.println("开始执行线程2去抢这把锁");
        thread10.print2();
    }

    //如果我们使用synchroized锁 这把锁的获得锁和释放锁都是由java虚拟机底层帮我们实现的
    //如果使用了Lock锁就相当于手动挡形式
    public void print1() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //获取锁
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + "获得锁成功");
                } catch (Exception e) {
                }finally{
                    //释放锁
                    lock.unlock();
                }
            }
        }, "t1").start();
    }

    public void print2() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                lock.lock();
                //如果我们使用lock获得锁了但是不释放锁就会导致 就导致等待的线程一直是阻塞状态
                System.out.println(2);
                System.out.println(Thread.currentThread().getName() + "获得锁成功");
            }
        }, "t2").start();
    }
}
