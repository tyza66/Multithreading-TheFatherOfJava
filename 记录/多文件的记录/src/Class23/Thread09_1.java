package Class23;

public class Thread09_1 extends Thread {
    //使用volatile关键字 保证线程可见性 不加的话子线程不会自己终止
    public volatile boolean isStart = true;
    @Override
    public void run() {
        while (isStart) {
            /*if(this.isInterrupted()){
                break;
            }*/
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread09_1 thread09 = new Thread09_1();
        thread09.start();
        //为了看子线程中断的效果 我们等三秒
        Thread.sleep(3000);
        //中断阻塞或者运行的线程
        System.out.println("中断子线程");
        thread09.isStart = false;
    }
}
