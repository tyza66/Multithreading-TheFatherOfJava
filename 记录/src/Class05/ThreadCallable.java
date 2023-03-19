package Class05;

import java.util.concurrent.Callable;

public class ThreadCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"子线程开始跑");
        Thread.sleep(3000);
        System.out.println(Thread.currentThread().getName()+"返回1");
        return 1;
    }
}
