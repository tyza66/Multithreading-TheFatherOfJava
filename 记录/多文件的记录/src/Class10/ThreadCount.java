package Class10;

public class ThreadCount implements Runnable {
    private int count = 100;
    Object objectLock = new Object();

    @Override
    //使用死循环让线程一直运行
    //如果在这个方法上加synchronized锁，那么这个程序就变成了单线程了 谁能获取到锁，谁就能运行该代码
    public void run() {
        while (true) {
            cal();
        }
        //同时执行的概念：现在可以有多个线程直接执行
    }

    public void cal(){
        if (count > 1) {
            try {
                Thread.sleep(30);
            } catch (Exception e) {
            }
            //synchronized锁保证了线程安全
            synchronized (objectLock){
                count--;
                System.out.println(Thread.currentThread().getName() + "." + count);
            }
        }
    }


    public static void main(String[] args) {
        //这里面是两个不同对象产生的线程了 会出现重复 对象锁是不允许重复的
        /*ThreadCount threadCount = new ThreadCount();
        ThreadCount threadCount2 = new ThreadCount();
        new Thread(threadCount).start();
        new Thread(threadCount2).start();*/
        ThreadCount threadCount = new ThreadCount();
        new Thread(threadCount).start();
        new Thread(threadCount).start();
    }
}
