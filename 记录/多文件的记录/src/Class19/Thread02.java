package Class19;

public class Thread02 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> System.out.println(Thread.currentThread().getName() + ",线程运行"), "t1");
        //如果需要顺序执行的话，t2是需要等待t1执行完毕
        Thread t2 = new Thread(() -> {
            try {
                //等t1执行完了才执行t2
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ",线程运行");
        }, "t2");
        //t3需要等待t2执行完毕
        Thread t3 = new Thread(() -> {
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ",线程运行");
        }, "t3");
        t1.start();
        t2.start();
        t3.start();
        //如果说使用的是直接启动的线程 执行顺序 主要看cpu调度的先后顺序

    }
}
