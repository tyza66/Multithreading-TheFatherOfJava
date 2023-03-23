package Class29;

public class Thread15 extends Object {
    public static void main(String[] args) {
        //我们想用wait必须结合synchronized锁
        //使用synchronized锁有可能会使用到对象锁
        //任意一个对象都需要wait和notify 所以放在了object类中
        //new Thread15().wait();
    }
}
