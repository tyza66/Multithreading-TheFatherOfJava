package Class30;

public class Thread16 extends Thread{
   private static int sum = 0;

    @Override
    public void run() {
        sum();
    }

    public void sum(){
        for(int i=0;i<10000;i++){
            sum++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread16 t1 = new Thread16();
        Thread16 t2 = new Thread16();
        t1.start();
        t2.start();
        //主线程会让t1和t2先执行
        //如果没出现线程安全问题的话最后出来的sum应该是20000
        //那么发生了线程安全问题后结果为什么会小于两万
        t1.join();
        t2.join();
        System.out.println(sum);
    }

}
