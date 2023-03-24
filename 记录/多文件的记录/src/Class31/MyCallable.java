package Class31;

public interface MyCallable<V> {
    //当前线程执行完毕返回的结果
    V call();
}
