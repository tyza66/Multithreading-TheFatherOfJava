package Class18;
public class Thread01 {
    private Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread01 thread01 = new Thread01();
        thread01.print();
        //主线程阻塞三秒的时间之后就唤醒子线程
        Thread.sleep(3000);
        thread01.notifyThread();
    }

    public void notifyThread(){
        synchronized (object){
            object.notify();
        }
    }

    public void print() throws InterruptedException {
        //synchronized (object) {
        //主线程主动释放了this锁 同时主线程进入了阻塞状态
        //然后我们用自己的代码块弄 还用了自己定义的object对象作为锁
        //代码段中调用那个锁的方法的调用必须是代码块里面的参数
        //不然就会报错
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    try {
                        System.out.println(Thread.currentThread().getName()+",1");
                        object.wait();
                        System.out.println(Thread.currentThread().getName()+",2");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        //}
    }
}
