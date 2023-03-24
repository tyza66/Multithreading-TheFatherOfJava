package Class31;

public class Thread17 {
    public static void main(String[] args) {
        MyCallableimpl myCallableimpl = new MyCallableimpl();
        MyFutureTask<Integer> myFutureTask = new MyFutureTask(myCallableimpl);
        new Thread(myFutureTask).start();
        Integer integer = myFutureTask.get();
        System.out.println(integer);
    }
}
