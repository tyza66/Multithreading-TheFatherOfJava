package Class25;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadCount implements Runnable {
    private int count = 100;
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            cal();
        }
    }

    public void cal() {
        try {
            lock.lock();
            if (count > 1) {
                count--;
                System.out.println(Thread.currentThread().getName() + "." + count);
            }
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        ThreadCount threadCount = new ThreadCount();
        new Thread(threadCount).start();
        new Thread(threadCount).start();
    }
}
