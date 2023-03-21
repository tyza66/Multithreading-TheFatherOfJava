package Class15;

import com.sun.org.apache.xpath.internal.objects.XObject;

public class Test02 {
    private Object objectLock = new Object();

    public static void main(String[] args) throws InterruptedException {
        new Test02().print();
        Thread.sleep(3000);
        //objectLock.notify(); 非静态成员不能被成员静态方法所调用
    }

    public void print() throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (objectLock) {
                    System.out.println(Thread.currentThread().getName()+":111");
                    try {
                        objectLock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+":222");
                }
            }
        }).start();
    }
}
