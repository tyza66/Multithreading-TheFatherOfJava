package Class12;
//这是锁竞争参产生的死锁 你要我不放 你要我也不放
public class DeadlockThread implements Runnable {
    private int count = 1;
    //自定义的对象作为锁
    private String lock = "lock";

    @Override
    public void run() {
        while (true) {
            count++;
            if (count % 2 == 0) {
                //进入a方法需要获取lock锁 --- 还要再去获取this锁
                synchronized (lock) {
                    a();
                }
            } else {
                //进入b方法需要获得this锁  --- 还要需要我们自定义那个lock锁
                synchronized (this) {
                    b();
                }
            }
        }
    }
    //进入a方法需要获取this锁
    public synchronized void a(){
        System.out.println(Thread.currentThread().getName()+",a方法。。。。");
    }

    public void b(){
        synchronized (lock){
            System.out.println(Thread.currentThread().getName()+",b方法。。。。");
        }
    }

    public static void main(String[] args) {
        DeadlockThread deadlockThread = new DeadlockThread();
        new Thread(deadlockThread).start();
        new Thread(deadlockThread).start();
        //卡住了
    }
}

