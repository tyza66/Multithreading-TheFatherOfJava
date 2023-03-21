package Class16;

public class Thread04 {
    class Res {
        public String userName;
        public char sex;
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
                    if (count == 0) {
                        res.userName = "java之父";
                        res.sex = '男';
                    } else {
                        res.userName = "java之母";
                        res.sex = '女';
                    }
                    count = (count + 1) % 2;
                }
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
                    System.out.println(res.userName + "," + res.sex);
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
        //一开始没上锁的时候。输出线程输出的里面有很多错乱的 我们需要给写的代码上锁
        //把锁放在循环里面的时候 输出的是对的了 但是这两个人得信输出是一片一片的
        //相当于输入的时候就不能输出，输出的时候不能输入
        inputThread.start();
        outputThread.start();
    }
}
