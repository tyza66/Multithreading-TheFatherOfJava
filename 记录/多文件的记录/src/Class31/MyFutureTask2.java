package Class31;

import java.util.concurrent.locks.LockSupport;

public class MyFutureTask2<V> implements Runnable {
    private MyCallable<V> myCallable;
    private Object lock = new Object();
    private V result;
    private Thread cuThread;

    public MyFutureTask2(MyCallable<V> myCallable) {
        this.myCallable = myCallable;
    }

    @Override
    public void run() {
        //执行线程需要执行的代码
        result = myCallable.call();
        /*synchronized (lock) {
            lock.notify();
        }*/
        //获得返回值之后解锁主线程 因为我们的子线程里面的逻辑是等待三秒 所以在主线程中几乎100%已经调用过get方法并且执行了cuThread = Thread.currentThread();
        //所以java之父说的没错
        //但是我们想要自己写一个放心可靠的futuretask的话这里可以加一个循环和sleep的组合 就是当cuThread没被赋值的时候一直等着它被赋值 他被赋值之后才去解锁 就好了 就不会出现那种概率性的死锁了
        if (cuThread != null) {
            LockSupport.unpark(cuThread);
        }
    }

    public V get() {
        /*synchronized (lock) {
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
        //主线程阻塞了
        cuThread = Thread.currentThread();
        LockSupport.park();
        return result;
    }
}
