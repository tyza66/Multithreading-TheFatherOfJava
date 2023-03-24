package Class31;

public class MyCallableimpl implements MyCallable<Integer> {
    //我们向Future的实现类中传递了一个callable的实现类的对象 （通过构造方法）
    //在这里实现 并且这个方法有返回值 现在还在实现Callable接口 暂时没涉及到FutureTask
    @Override
    public Integer call() {
        System.out.println(Thread.currentThread().getName() + ",当前子线程在执行耗时的代码");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //耗时代码执行完之后就返回1
        return 1;
    }
}
