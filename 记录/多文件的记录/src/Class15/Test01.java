package Class15;

public class Test01 {
    public static void main(String[] args) throws InterruptedException {
        //Object对象自带有这些方法
        //这样直接调用会报错 因为没有告诉这个锁的资源（锁对象）
        //wait还有notify是要结合我们的synchronized锁使用的
        new Test01().print();
    }

    public void print() throws InterruptedException {
        //wait方法会释放锁的资源，同时当前线程会阻塞
        //结合synchronized锁使用的
        synchronized (this){
            this.wait();
        }
    }
}
