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
                    //如果时间到了，不是立即变成的运行状态，而是解除休眠状态之后由就绪状态经过cpu的调度变成了运行状态，不是直接进入运行状态
                    //线程有两种状态，就绪状态和运行状态
                    //如果我有两个cpu，那么我的两个cpu就可以同时把两个减减的线程可以同时执行，冲突的概率非常大
                    //Thread.sleep(30);
                    //sleep之后因为放了cpu执行权，之后从就绪到运行，他的冲突的概率就非常大
                    //如果没有sleep，那么一大片的代码都是其中一个线程在执行，所以错误的少点
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
        //这里因为两个线程创建的时候使用的是同一个实现了Runnable接口的对象来创建的所以那个成员变量被这两个线程操作了，出现了线程不安全的问题
        new Thread(threadCount).start();
        new Thread(threadCount).start();
    }
}
