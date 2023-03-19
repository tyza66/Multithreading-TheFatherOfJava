package Class06;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test03 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"我是子线程");
            }
        });
    }
}
