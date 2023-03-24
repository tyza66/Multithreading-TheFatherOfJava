package Class31;

public class Thread17 {
    public static void main(String[] args) {
        MyCallableimpl myCallableimpl = new MyCallableimpl();
        MyFutureTask2<Integer> myFutureTask = new MyFutureTask2(myCallableimpl);
        new Thread(myFutureTask).start();
        Integer integer = myFutureTask.get();
        System.out.println(integer);
    }
}
