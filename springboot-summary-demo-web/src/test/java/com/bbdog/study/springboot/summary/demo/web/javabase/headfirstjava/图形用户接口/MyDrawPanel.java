package com.bbdog.study.springboot.summary.demo.web.javabase.headfirstjava.图形用户接口;

import javax.swing.*;
import java.awt.*;

/**
 * <p>
 *
 * </p>
 *
 * @author cheng.wang
 * @version Id：MyDrawPanel.java Date：2022/2/12 17:03 Version：1.0
 */
public class MyDrawPanel extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.orange);
        g.fillRect(20, 50, 100, 100);
    }
}
