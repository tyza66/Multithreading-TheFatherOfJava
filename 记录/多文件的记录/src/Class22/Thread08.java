package Class22;

public class Thread08 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){

                }
            }
        },"我是子线程");
        thread.setDaemon(true);
        thread.start();
        System.out.println("我的主线程执行完毕");
        //如果我们想做到主线程停掉的时候子线程也停 我们设置守护线程
        //跟着主线程走 主线程停了 守护线程跟着一起停 而且不管执行完没执行完
    }
}
