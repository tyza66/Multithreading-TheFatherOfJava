package Class20;

public class Thread01 extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"<我是子线程>");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("子线程完事了");
    }

    public static void main(String[] args) {
        //启动线程用的是start而不是run
        System.out.println(Thread.currentThread().getName()+"我是主线程");
        new Thread01().start();
        new Thread01().start();
        System.out.println("main,voer!");
        //现在会主动释放锁并且当前线程会进去阻塞的状态 没被唤醒就一直阻塞
        //new Thread01().wait();
        //wait可以设置等待时间 加入我设置成1000 那么就是在一秒之后 会超时 一直没人唤醒的话就会自己醒过来
        //new Thread01().wait(1000);
    }
}
