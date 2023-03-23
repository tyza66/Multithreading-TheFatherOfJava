package Class27;

public class Thread13 {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            int count = 0;
            for(;;){
                System.out.println(Thread.currentThread().getName()+","+count++);
            }
        },"t1线程");
        Thread t2 = new Thread(()->{
            int count = 0;
            for(;;){
                System.out.println(Thread.currentThread().getName()+","+count++);
            }
        },"t2线程");
        //优先级设置成最小
        t1.setPriority(Thread.MAX_PRIORITY);
        //优先级设置成最小
        t2.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
        //多运行一会发现t1比2
    }
}
