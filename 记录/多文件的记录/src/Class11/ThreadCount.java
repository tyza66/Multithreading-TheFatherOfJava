package Class11;

public class ThreadCount implements Runnable {
    private int count = 100;
    Object objectLock = new Object();

    @Override
    //使用死循环让线程一直运行
    //如果在这个方法上加synchronized锁，那么这个程序就变成了单线程了 谁能获取到锁，谁就能运行该代码
    public void run() {
        while (true) {
            try {
                Thread.sleep(30);
            } catch (Exception e) {
            }
            cal();
        }
        //同时执行的概念：现在可以有多个线程直接执行
    }

    //加在实例方法上的时候默认使用的是this锁
    //就是等同于在里面的所有逻辑上面加上了一个synchronizeds锁
    //如果加载了静态方法上，就不是this锁（自己写可以不可以是），是类名称.class作为锁
    //同一个类只可以有一个class，也能保证线程安全锁
    public synchronized void cal(){
        if (count > 1) {
                count--;
                System.out.println(Thread.currentThread().getName() + "." + count);
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
