package Class12;

public class DeadlockThread implements Runnable {
    private int count = 1;
    private String lock = "lock";

    @Override
    public void run() {
        while (true) {
            count++;
            if (count % 2 == 0) {
                synchronized (lock) {
                    a();
                }
            } else {
                synchronized (this) {
                    b();
                }
            }
        }
    }
    public synchronized void a(){
        System.out.println(Thread.currentThread().getName()+",a方法。。。。");
    }

    public void b(){
        synchronized (lock){
            System.out.println(Thread.currentThread().getName()+",b方法。。。。");
        }
    }
}

