package Class28;

public class Thread14 {
    public static void main(String[] args) throws InterruptedException {
        new Thread14().cal();
    }
    public synchronized void cal() throws InterruptedException {
        //主动释放对象锁synchronized 让当前进程变为等待的状态
        //如果wait不在同步代码块里面 会报错
        this.wait();
    }

    public void cal2() throws InterruptedException {
        Thread.sleep(3000);
    }
}
