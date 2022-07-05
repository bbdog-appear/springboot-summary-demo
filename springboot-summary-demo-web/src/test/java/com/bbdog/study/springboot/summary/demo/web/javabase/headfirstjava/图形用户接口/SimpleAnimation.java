package com.bbdog.study.springboot.summary.demo.web.javabase.headfirstjava.图形用户接口;

import javax.swing.*;
import java.awt.*;

/**
 * <p>
 *      完整的动画程序
 * </p>
 *
 * @author cheng.wang
 * @version Id：SimpleAnimation.java Date：2022/2/16 13:57 Version：1.0
 */
public class SimpleAnimation {

    int x = 70;
    int y = 70;

    public static void main(String[] args) {
        SimpleAnimation gui = new SimpleAnimation();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(drawPanel);
        frame.setSize(300, 300);
        frame.setVisible(true);

        for (int i = 0; i < 130; i++) {
            x++;
            y++;

            drawPanel.repaint();
            try {
                Thread.sleep(50);
            } catch (Exception e) {
                System.out.println("exception");
            }
        }
    }

    class MyDrawPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            g.setColor(Color.white);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());

            g.setColor(Color.green);
            g.fillOval(x, y, 40, 40);
        }
    }

}
