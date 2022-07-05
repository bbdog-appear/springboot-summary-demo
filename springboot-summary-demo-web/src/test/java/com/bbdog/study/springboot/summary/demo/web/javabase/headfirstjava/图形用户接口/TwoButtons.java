package com.bbdog.study.springboot.summary.demo.web.javabase.headfirstjava.图形用户接口;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <p>
 *      多重监听，当每个按钮执行不同工作时，要如何对两个不同的按钮分别取得事件呢？
 *      1、内部类就是救星，内部的类对外部的类有一张特殊的通行证，能够自由的存取它的内容，就算是私用的内容也一样。内部类可以把外部的方法或变量当做
 *        是自己的。这就是为何内部类非常好用的原因，除了跟正常的类没有差别之外，还多了特殊的存取权。
 *      2、内部类的作用：需求中需要有两个按钮事件，如果是一个按钮事件，那直接TwoButtons实现ActionListener，并重写方法即可。但是这时候有两个事件
 *        但是又不能重写两次actionPerformed方法。那么这时候就会想到，在外部定义两个类，分别实现ActionListener，分别重写actionPerformed方法，
 *        但是这样就拿不到TwoButtons对象中的label或frame属性。所以只能用内部类，既能拿到TwoButtons对象状态，又能分别实现两种不同的事件。
 *        书中解释：你不能同时又是Dog又是按钮，但有时又必须这样。Dog可以继承Animal却有个内部的类来代表按钮的行为，因此在有需要的时候Dog就可以派出
 *        内部的类来代表按钮。
 *        也就是说：当两个事件需要对GUI类的实例变量有特殊的存取权时，需要用到内部类。
 *      3、举例：比如一个类实现一个接口，但是这个类实现接口的方法，要有两个功能。就不满足，这时候可以用子类继承父类，然后实现这个方法，并且还要
 *        用到父类的实例变量。但是另一个功能和这个类不相关，那么就可以使用内部类。另外内部类不是有..关系，感觉像是是..关系，也就是不是实例变量。
 * </p>
 *
 * @author cheng.wang
 * @version Id：TwoButtons.java Date：2022/2/12 16:47 Version：1.0
 */
public class TwoButtons {

    private JLabel label;
    private JFrame frame;

    public static void main(String[] args) {
        TwoButtons gui = new TwoButtons();
        gui.go();
    }

    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton labelButton = new JButton("Change Label");
        labelButton.addActionListener(new LabelListener());

        JButton colorButton = new JButton("Change Circle");
        colorButton.addActionListener(new ColorListener());

        label = new JLabel("I`m a label");
        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.WEST, label);

        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    class LabelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // 内部类可以直接存取label
            label.setText("Ouch!");
        }
    }

    class ColorListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // 直接存取frame，不需要明确指定外部类的引用
            frame.repaint();
        }
    }

}
