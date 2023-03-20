package Class08;

public class ThreadCount implements Runnable {
    private int count = 100;

    @Override
    //使用死循环让线程一直运行
    public void run() {
        while (true) {
            if (count > 1) {
                try {
                    //运行状态--如果调用了sleep，就从运行状态变成了休眠状态，就可以吧cpu执行权给其他线程用
                    //如果时间到了，
                    //线程有两种状态，就绪状态和运行状态
                    Thread.sleep(30);
                } catch (Exception e) {
                }
                count--;
                System.out.println(Thread.currentThread().getName() + "." + count);
            }
        }
        //同时执行的概念：现在可以有多个线程直接执行
    }

    public static void main(String[] args) {
        ThreadCount threadCount = new ThreadCount();
        new Thread(threadCount).start();
        new Thread(threadCount).start();
    }
}
