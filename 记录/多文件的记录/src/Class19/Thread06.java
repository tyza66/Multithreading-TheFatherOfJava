package Class19;

public class Thread06 {
    private Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread06 thread06 = new Thread06();
        Thread thread = thread06.print();
        thread.start();
        Thread.sleep(3000);
        //当对一个线程，调用 interrupt () 时，如果线程处于被阻塞状态（例如处于sleep, wait, join 等状态），那么线程将立即退出被阻塞状态，并抛出一个InterruptedException异常。如果线程处于正常活动状态，那么会将该线程的中断标志设置为 true。被设置中断标志的线程将继续正常运行，不受影响。interrupt()方法并不会立即停止线程，需要被调用的线程自己进行配合才行。
        //中断的时候线程如果处于sleep, wait, join 等阻塞状态的时候 就会先唤醒之后抛出异常
        thread.interrupt();
    }

    public Thread print(){
        Thread thread = new Thread(()->{
            synchronized (object){
                System.out.println("1");
                try {
                    object.wait(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("2");
            }
        });
        return thread;
    }
}
