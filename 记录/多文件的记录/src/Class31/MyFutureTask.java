package Class31;

public class MyFutureTask<V> implements Runnable {
    private MyCallable<V> myCallable;
    private Object lock = new Object();
    private V result;

    public MyFutureTask(MyCallable<V> myCallable) {
        this.myCallable = myCallable;
    }

    //把Future传递给Thread的构造方法后 线程就运行这个run方法里面的内容
    //run方法里面调用了Callable实现类中实现的call方法（多态） 运行了我们实现的Callable的类中call中写的逻辑
    @Override
    public void run() {
        //执行线程需要执行的代码
         result = myCallable.call();
        //子线程执行完毕 唤醒主线程 就可以拿到返回结果了
        synchronized (lock){
            lock.notify();
        }
    }
    //通过get方法阻塞主线程之后拿到返回值
    //相当于让主线程在这等待子线程的返回结果返回给主线程
    public V get(){
        //获取子线程异步执行完毕之后返回的结果
        //拿到之前先让主线程先阻塞
        synchronized (lock){
            //谁调用这个wait方法谁就阻塞 现在我们就要用主线程调用的get方法 主线程就会阻塞
            //如果result拿到了结果说明子线程执行完毕了 如果子线程执行完毕 那就唤醒那个锁
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
