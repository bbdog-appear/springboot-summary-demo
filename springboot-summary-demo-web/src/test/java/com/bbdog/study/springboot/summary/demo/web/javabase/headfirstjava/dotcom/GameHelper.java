package com.bbdog.study.springboot.summary.demo.web.javabase.headfirstjava.dotcom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p>
 *      游戏助手类
 * </p>
 *
 * @author cheng.wang
 * @version Id：GameHelper.java Date：2021/12/29 10:31 Version：1.0
 */
public class GameHelper {

    public String getUserInput(String prompt) {
        String inputLine = null;
        System.out.println(prompt + "");
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0)
                return null;
        } catch (IOException e) {
            System.out.println("IOException:" + e);
        }
        return inputLine;
    }

}
