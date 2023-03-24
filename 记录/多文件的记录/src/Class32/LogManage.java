package Class32;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class LogManage {
    //缓存日志内容 先不管线程没法消费的话这个东西存满的情况
    private BlockingDeque<String> blockingDeque = new LinkedBlockingDeque<String>();
    private LogThread logThread;
    private String filePath = "C:\\Users\\shun_\\Desktop\\Project\\Public\\Multithreading-TheFatherOfJava\\记录\\多文件的记录\\log\\log.txt";

    public LogManage(){
        logThread = new LogThread();
        logThread.start();
    }
    public void info(String log) {
        //将日志先缓存起来放进队列中
        blockingDeque.offer(log);
    }
    class LogThread extends Thread{
        @Override
        public void run() {
            while (true){
                String log = blockingDeque.poll();
                //javaee中使用这些东西需要导入资料中那个jar包
                if(!StringUtils.isEmpty(log)){
                    //再将该日志写入磁盘中 这里java之父用了工具类 我没有 自己简单写了一个
                    try {
                        write(filePath,log);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    /*这里突然发现java之父的是Springboot项目 好家伙 下面这些就全用文字吧
                        之后他介绍了一下aop切片 说可以拦截一个包下面所有的请求 之后使用前置和后置请求
                        之后通过Aop获得请求的内容 将收集到的信息全都异步写入磁盘进行叠加
                       */
                }
            }
        }
    }
    public void write(String path,String log) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(new File(path));
        writer.println(log);
        writer.close();
    }
}
