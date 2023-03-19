package Class04;

public class Thread02 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"<我是子线程>");
    }

    //常用的是实现runnable接口，因为方便函数编程
    public void runThread2(Thread02 a){
        new Thread(a).start();
    }

    public static void main(String[] args) {
        //new Thread02().runThread2(new Thread02());
        //java8新特性 lambda表达式
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"<我是子线程>");
            }
        }).start();
        //变完
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"<我是子线程>");
        }).start();
    }
}

