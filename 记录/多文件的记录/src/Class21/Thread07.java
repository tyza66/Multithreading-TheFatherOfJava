package Class21;

public class Thread07 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            //运行在cpu之上 线程会一直执行 很可能会引发cpu直接飙高
            //所以在生产环境一定不要写死循环代码 即使写了 死循环代码也要及时退出
            public void run() {
                while(true){
                    try {
                        //这样的话占比就会很低
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
