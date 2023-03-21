package Class15;

public class Class15 {
    /*
        初学者可能不好理解这个notify还有wait
        notify就是通知一个等待在对象上的线程，使其从main()方法返回，二返回的前提是该线程的到了对象的的锁
        notitfAll就是通知所有在等待的线程
        wait就是使得调用这个方法的线程进入waiting状态，只有等待其他线程的通知或者被中断，才会返回，要注意，wait的时候对象的锁会被释放

    */
}
