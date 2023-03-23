package Class26;

public class Thread12 extends Thread {
    public Thread12(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            if (i == 30) {
                System.out.println(Thread.currentThread().getName() + ",释放cpu执行权");
                this.yield();
            } else {
                System.out.println(Thread.currentThread().getName() + "," + i);
            }
        }
    }

    public static void main(String[] args) {
        new Thread12("giao1").start();
        new Thread12("giao2").start();
    }
}
