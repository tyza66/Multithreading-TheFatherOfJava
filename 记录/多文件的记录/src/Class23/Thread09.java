package Class23;

public class Thread09 extends Thread {
    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(1);
                Thread.sleep(10000000);
                System.out.println(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread09 thread09 = new Thread09();
        thread09.start();
        //为了看子线程中断的效果 我们等三秒
        Thread.sleep(3000);
        //中断阻塞或者运行的线程
        System.out.println("中断子线程");
        //中断了相当于直接从运行到了死亡状态 抛出异常属于正常情况
        thread09.interrupt();
    }
}
