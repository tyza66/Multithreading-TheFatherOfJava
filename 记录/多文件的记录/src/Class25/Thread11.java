package Class25;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Thread11 {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public static void main(String[] args) {
        Thread11 thread11 = new Thread11();
        thread11.cal();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //三秒之后子线程就会唤醒主线程
        thread11.signal();
    }

    public void signal() {
        try {
            lock.lock();
            //唤醒方法调用的是这个 相当于那个里面的notify 唤醒也是要在当前获取锁的情况下去做的
            condition.signal();
        } catch (Exception e) {
        } finally {
            lock.unlock();
        }

    }

    public void cal() {
        //要是用Lock里面的wait和niotify功能先要拿到这个
        // Condition condition = lock.newCondition();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    System.out.println(1);
                    //主动的释放锁 并且当前线程回传处于阻塞状态 前提是先拿到了锁
                    condition.await();
                    System.out.println(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();
        //夏天打卡天门山 秋天打卡老黑山
    }
}
