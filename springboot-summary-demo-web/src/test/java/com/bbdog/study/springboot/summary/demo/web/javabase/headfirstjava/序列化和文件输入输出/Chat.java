package com.bbdog.study.springboot.summary.demo.web.javabase.headfirstjava.序列化和文件输入输出;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * <p>
 *      如果变量不能被序列化，可以是设计者忘记实现Serializable，或者动态数据只可以在执行时求出而不能或不必储存，虽然java函数库中
 *      大部分的类可以被序列化，你还是无法将网络联机之类的东西保存下来。它得要在执行期当场创建才有意义。一旦程序关闭之后，联机本身
 *      就不再有用，下次执行时需要重新创建出来。
 * </p>
 *
 * @author cheng.wang
 * @version Id：Chat.java Date：2022/3/10 14:19 Version：1.0
 */
public class Chat implements Serializable {

    /**
     * 如果你需要序列化程序能够跳过某个实例变量，就把它标记为transient的变量
     */
    private transient String currentID;
    private String userName;

    public static void main(String[] args) {
        Chat chat = new Chat();
        try {
            FileOutputStream fos = new FileOutputStream("Pond.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            // chat对象必须可以被序列化
            oos.writeObject(chat);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
