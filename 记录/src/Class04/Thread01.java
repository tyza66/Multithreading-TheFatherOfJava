package Class04;

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
    }
}
