package Class32;

import java.util.concurrent.LinkedBlockingDeque;

public class Test02 {
    public static void main(String[] args) {
        //JUC并发包中有一个BlockingDeque 我们使用的是LinkedBlockingDeque 这个东西默认是无界的 就是可以无限存放内容
        LinkedBlockingDeque<String> blockingDeque = new LinkedBlockingDeque<>();
        //使用offer往当前这个容器中存放
        blockingDeque.offer("log1");
        blockingDeque.offer("log1");
        //从当前队列中取出一个 可以取出来log1
        System.out.println(blockingDeque.poll());
        System.out.println(blockingDeque.poll());
        System.out.println(blockingDeque.poll());
        //我们只要这样 再异步开启一个线程将日志写入到磁盘中
    }
}
