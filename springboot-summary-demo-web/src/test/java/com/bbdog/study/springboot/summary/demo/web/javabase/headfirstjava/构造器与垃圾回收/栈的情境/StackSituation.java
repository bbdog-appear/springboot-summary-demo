package com.bbdog.study.springboot.summary.demo.web.javabase.headfirstjava.构造器与垃圾回收.栈的情境;

/**
 * <p>
 *     方法执行时栈的情境：
 *      下面三个方法，第一个方法在执行过程中会调用第二个方法，第二个会调用第三个。每个方法都在内容中声明一个局部变量，而go()方法
 *      还有声明一个参数(这代表go()方法由两个局部变量)
 *      1、某段程序代码调用了doStuff()使得doStuff()被放在stack最上方的栈块中。
 *      2、doStuff()调用go()。go()就被放在栈顶。
 *      3、go()又调用crazy()使得crazy()现在处于栈顶。
 *      4、当crazy()执行完成后，它的堆栈块就被释放掉(栈顶的crazy()出栈)。执行完就回到了go()。
 * </p>
 *
 * @author cheng.wang
 * @version Id：StackSituation.java Date：2022/1/12 18:03 Version：1.0
 */
public class StackSituation {

    public void doStuff() {
        boolean b = true;
        go(4);
    }

    public void go(int x) {
        int z = x + 24;
        crazy();
        // 假设还有很多程序代码
    }

    public void crazy() {
        char c = 'a';
    }

}
