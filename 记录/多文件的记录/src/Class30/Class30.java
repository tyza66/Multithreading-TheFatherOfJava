package Class30;

public class Class30 {
    /*
        站在字节码角度和上下文切换的角度来分析线程安全问题
        线程安全问题要从字节码层面和上下文切换的角度去看
        JUB并发编程开始就会提高一个jmm java内存模型
        程序中小于20000的原因在代码中是看不出来的 我们就需要从底层来看
        java的源代码编译成class文件之后 编译成了字节码
        我么可以把字节码反汇编
        使用javap -p -v Thread16.class
//         Last modified 2023-3-23; size 995 bytes
//  MD5 checksum b950e8ed86e7528c792f87c018a5dfe7
//  Compiled from "Thread16.java"
//public class Class30.Thread16 extends java.lang.Thread
//  minor version: 0
//  major version: 52
//  flags: ACC_PUBLIC, ACC_SUPER
//Constant pool:
//   #1 = Methodref          #10.#34        // java/lang/Thread."<init>":()V
//   #2 = Methodref          #4.#35         // Class30/Thread16.sum:()V
//   #3 = Fieldref           #4.#36         // Class30/Thread16.sum:I
//   #4 = Class              #37            // Class30/Thread16
//   #5 = Methodref          #4.#34         // Class30/Thread16."<init>":()V
//   #6 = Methodref          #4.#38         // Class30/Thread16.start:()V
//   #7 = Methodref          #4.#39         // Class30/Thread16.join:()V
//   #8 = Fieldref           #40.#41        // java/lang/System.out:Ljava/io/PrintStream;
//   #9 = Methodref          #42.#43        // java/io/PrintStream.println:(I)V
//  #10 = Class              #44            // java/lang/Thread
//  #11 = Utf8               sum
//  #12 = Utf8               I
//  #13 = Utf8               <init>
//  #14 = Utf8               ()V
//  #15 = Utf8               Code
//  #16 = Utf8               LineNumberTable
//  #17 = Utf8               LocalVariableTable
//  #18 = Utf8               this
//  #19 = Utf8               LClass30/Thread16;
//  #20 = Utf8               run
//  #21 = Utf8               i
//  #22 = Utf8               StackMapTable
//  #23 = Utf8               main
//  #24 = Utf8               ([Ljava/lang/String;)V
//  #25 = Utf8               args
//  #26 = Utf8               [Ljava/lang/String;
//  #27 = Utf8               t1
//  #28 = Utf8               t2
//  #29 = Utf8               Exceptions
//  #30 = Class              #45            // java/lang/InterruptedException
//  #31 = Utf8               <clinit>
//  #32 = Utf8               SourceFile
//  #33 = Utf8               Thread16.java
//  #34 = NameAndType        #13:#14        // "<init>":()V
//  #35 = NameAndType        #11:#14        // sum:()V
//  #36 = NameAndType        #11:#12        // sum:I
//  #37 = Utf8               Class30/Thread16
//  #38 = NameAndType        #46:#14        // start:()V
//  #39 = NameAndType        #47:#14        // join:()V
//  #40 = Class              #48            // java/lang/System
//  #41 = NameAndType        #49:#50        // out:Ljava/io/PrintStream;
//  #42 = Class              #51            // java/io/PrintStream
//  #43 = NameAndType        #52:#53        // println:(I)V
//  #44 = Utf8               java/lang/Thread
//  #45 = Utf8               java/lang/InterruptedException
//  #46 = Utf8               start
//  #47 = Utf8               join
//  #48 = Utf8               java/lang/System
//  #49 = Utf8               out
//  #50 = Utf8               Ljava/io/PrintStream;
//  #51 = Utf8               java/io/PrintStream
//  #52 = Utf8               println
//  #53 = Utf8               (I)V
//{
//  private static int sum;
//    descriptor: I
//    flags: ACC_PRIVATE, ACC_STATIC
//
//  public Class30.Thread16();
//    descriptor: ()V
//    flags: ACC_PUBLIC
//    Code:
//      stack=1, locals=1, args_size=1
//         0: aload_0
//         1: invokespecial #1                  // Method java/lang/Thread."<init>":()V
//         4: return
//      LineNumberTable:
//        line 3: 0
//      LocalVariableTable:
//        Start  Length  Slot  Name   Signature
//            0       5     0  this   LClass30/Thread16;
//
//  public void run();
//    descriptor: ()V
//    flags: ACC_PUBLIC
//    Code:
//      stack=1, locals=1, args_size=1
//         0: aload_0
//         1: invokevirtual #2                  // Method sum:()V
//         4: return
//      LineNumberTable:
//        line 8: 0
//        line 9: 4
//      LocalVariableTable:
//        Start  Length  Slot  Name   Signature
//            0       5     0  this   LClass30/Thread16;
//
//  public void sum();
//    descriptor: ()V
//    flags: ACC_PUBLIC
//    Code:
//      stack=2, locals=2, args_size=1
//         0: iconst_0
//         1: istore_1
//         2: iload_1
//         3: sipush        10000
//         6: if_icmpge     23
//         9: getstatic     #3                  // Field sum:I
//        12: iconst_1
//        13: iadd
//        14: putstatic     #3                  // Field sum:I
//        17: iinc          1, 1
//        20: goto          2
//        23: return
//      LineNumberTable:
//        line 12: 0
//        line 13: 9
//        line 12: 17
//        line 15: 23
//      LocalVariableTable:
//        Start  Length  Slot  Name   Signature
//            2      21     1     i   I
//            0      24     0  this   LClass30/Thread16;
//      StackMapTable: number_of_entries = 2
//        frame_type = 252 /* append */
//    offset_delta = 2
//    locals = [ int ]
//    frame_type = 250 /* chop */
//    offset_delta = 20
//
//    public static void main(java.lang.String[]) throws java.lang.InterruptedException;
//    descriptor: ([Ljava/lang/String;)V
//    flags: ACC_PUBLIC, ACC_STATIC
//    Code:
//    stack=2, locals=3, args_size=1
//            0: new           #4                  // class Class30/Thread16
//            3: dup
//         4: invokespecial #5                  // Method "<init>":()V
//            7: astore_1
//         8: new           #4                  // class Class30/Thread16
//                 11: dup
//        12: invokespecial #5                  // Method "<init>":()V
//            15: astore_2
//        16: aload_1
//        17: invokevirtual #6                  // Method start:()V
//            20: aload_2
//        21: invokevirtual #6                  // Method start:()V
//            24: aload_1
//        25: invokevirtual #7                  // Method join:()V
//            28: aload_2
//        29: invokevirtual #7                  // Method join:()V
//            32: getstatic     #8                  // Field java/lang/System.out:Ljava/io/PrintStream;
//            35: getstatic     #3                  // Field sum:I
//            38: invokevirtual #9                  // Method java/io/PrintStream.println:(I)V
//            41: return
//    LineNumberTable:
//    line 18: 0
//    line 19: 8
//    line 20: 16
//    line 21: 20
//    line 25: 24
//    line 26: 28
//    line 27: 32
//    line 28: 41
//    LocalVariableTable:
//    Start  Length  Slot  Name   Signature
//            0      42     0  args   [Ljava/lang/String;
//            8      34     1    t1   LClass30/Thread16;
//           16      26     2    t2   LClass30/Thread16;
//    Exceptions:
//            throws java.lang.InterruptedException
//
//    static {};
//    descriptor: ()V
//    flags: ACC_STATIC
//    Code:
//    stack=1, locals=0, args_size=0
//            0: iconst_0
//         1: putstatic     #3                  // Field sum:I
//            4: return
//    LineNumberTable:
//    line 4: 0
//}
//SourceFile: "Thread16.java"
    /*
        进行了反汇编之后找到汇编代码中sum方法对应的位置
        我们的sum++就等同于
        //         9: getstatic     #3          获取静态变量值sum         // Field sum:I 等同于对全局共享变量进行++操作
        //        12: iconst_1                  准备一个常量1
        //        13: iadd                      自增
        //        14: putstatic     #3          将修改后的值存取静态变量sum        // Field sum:I
        这一段代码
        sum+在底层是这样四行代码
        #3指的是常量池里面里面存的东西 获取的是全局静态变量sum 需要+1就得声明常量1 之后对sum进行自增 之后将修改后的值给全局共享变量sum
        之后进入cpu上下文切换的角度进行分析
        假如说现在有t1和t2两个线程进行++ 底层是像上面那样四句话执行的
        这里面有一些抽象有一点绕
        假设只有一个cpu的时候 运行两个线程肯定会发生上下文切换（多个线程在cpu上轮流执行）
        假如线运行了t1线程 ：
                1.获取了sum = 0
                2.声明常量1
                3.做自增，也就是sum+1
        如果这时候突然去执行t2线程了
        ！！！！！
        这时候t2线程来执行完之后，t1线程第四条指令（4.sum=1）才会执行 这样就丢失掉了t2中执行的一次++操作了
        现在这两个线程一共对sum执行了两次，但是我们的执行结果只算了一次
        我们的结果不是等于二而是等于一
        正因为底层如此 所以发生线程安全问题后那个结果会小于两万！！！
        就是因为有些赋值操作丢失了
        这些在国外很多关于jvm的书籍中又谈到

    */
}
