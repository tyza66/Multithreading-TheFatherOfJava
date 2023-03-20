package Class12;

public class Class12 {
    /*
        synchronized锁会出现死锁问题
        多线程的过程中一定要想象他们在同时执行
        线程1和线程2同时执行
        线程一拿到了lock对象锁，线程2获得了this锁
        线程一需要线程二释放this锁，线程2需要线程一释放lock锁，就死锁了
        在jdk中有一个诊断线程死锁的工具\jdk8\bin\jconsole.exe
        在jdk安装目录找到jconsole.exe 不安全连接
        下面有一个检测死锁 甚至可以定位到哪个锁哪一行代码
    */
}
