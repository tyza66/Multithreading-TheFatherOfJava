package Class17;

public class Thread04 {
    class Res {
        public String userName;
        public char sex;
        //flag的默认值是FALSE
        //如果flag的值是false 输入线程就可以输入值 输出线程就需要阻塞等待 如果现在输出线程先拿到锁了，但是现在的flag等于的额是false
        //如果flag的值是true 输出线程就可以输出值
        public boolean flag = false;
    }

    //输入的线程
    class InputThread extends Thread {
        private Res res;

        public InputThread(Res res) {
            this.res = res;
        }

        @Override
        public void run() {
            int count = 0;
            while (true) {
                synchronized (res) {
                    if (res.flag) {
                        try {
                            res.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (count == 0) {
                        res.userName = "java之父";
                        res.sex = '男';
                    } else {
                        res.userName = "java之母";
                        res.sex = '女';
                    }
                    //让输出线程输出值
                    res.flag = true;
                    //唤醒输出线程
                    res.notify();
                }
                count = (count + 1) % 2;
            }
        }
    }

    //输出的线程
    class OutputThread extends Thread {
        private Res res;

        public OutputThread(Res res) {
            this.res = res;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (res) {
                    if (!res.flag) {
                        //当前如果res.flag等于的是fasle 那么输出的线程主动释放锁
                        //wait释放锁并且当前线程会阻塞
                        try {
                            res.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(res.userName + "," + res.sex);
                    //输出完毕了 现在交给输入线程继续输入
                    res.flag = false;
                    res.notify();
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread04().print();
    }

    public void print() {
        //全局对象
        Res res = new Res();
        //输入线程
        InputThread inputThread = new InputThread(res);
        //输出线程
        OutputThread outputThread = new OutputThread(res);
        //我们想要实现交替的输出 现在是一片的
        //解决这个问题就要用到wait还有notify
        inputThread.start();
        outputThread.start();
    }
}
