package Class05;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.LockSupport;

public class Thread02 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadCallable threadCallable = new ThreadCallable();
        FutureTask<Integer> integerFutureTask = new FutureTask<Integer>(threadCallable);
        new Thread(integerFutureTask).start();
        //必须有返回结果之后主程序才能从上往下的执行
        //主线程必须等待Collable给返回结果
        Integer integer = integerFutureTask.get();
        System.out.println(Thread.currentThread().getName()+","+integer);
        //直接让当前线程阻塞
        LockSupport.park();
        System.out.println(1);
        //直接让当前线程唤醒
        LockSupport.park();
    }
}
