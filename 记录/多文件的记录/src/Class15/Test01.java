package Class15;

public class Test01 {
    //Object对象自带有这些方法 wait的时候就得用锁代码段用的锁 才不会报错
    Object objectLock = new Object();

    //如果是自己定义的object锁，那
    public static void main(String[] args) throws InterruptedException {
        //这样直接调用会报错 因为没有告诉这个锁的资源（锁对象）
        //wait还有notify是要结合我们的synchronized锁使用的
        new Test01().print();
    }

    public void print() throws InterruptedException {
        //wait方法会释放锁的资源，同时当前线程会阻塞
        //结合synchronized锁使用的
        synchronized (objectLock) {
            System.out.println("111");
            //主线程释放锁资源，通知主线程也会阻塞
            objectLock.wait();
            //如果new一个新的对象调用wait
            //new Test01().wait(); 像这样调用会报错 必须用锁的对象wait
            System.out.println("222");
        }
    }
}
