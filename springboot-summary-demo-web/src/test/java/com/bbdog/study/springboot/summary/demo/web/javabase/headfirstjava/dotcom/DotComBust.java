package com.bbdog.study.springboot.summary.demo.web.javabase.headfirstjava.dotcom;

import java.util.ArrayList;

/**
 * <p>
 *      击沉网站测试
 * </p>
 *
 * @author cheng.wang
 * @version Id：DotComBust.java Date：2022/1/5 10:15 Version：1.0
 */
public class DotComBust {

    private GameHelper helper = new GameHelper();
    private static ArrayList<DotCom> dotcomsList = new ArrayList<>();
    private int numOfGuesses = 0;

    // 类加载时，会执行该静态代码块，且只会执行一次
    static {
        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("eToys.com");
        DotCom three = new DotCom();
        three.setName("Go2.com");
        dotcomsList.add(one);
        dotcomsList.add(two);
        dotcomsList.add(three);
    }

    /**
     * 初始化DotCom列表
     */
    private void setUpGame() {
        for (DotCom dotComToSet : dotcomsList) {
            // 设置DotCom的位置
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);
        }
    }

    /**
     * 开始玩游戏
     */
    private void startPlaying() {
        while (!dotcomsList.isEmpty()) {
            // 取得玩家输入
            String userGuess = helper.getUserInput("Enter a guess");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    /**
     * 判断用户猜测值是否命中DotCom的某个位置，如果击沉一个网站，则从列表中删除该DotCom
     *
     * @param userGuess 用户猜测值
     */
    private void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "miss";
        for (DotCom dotCom : dotcomsList) {
            result = dotCom.checkYourself(userGuess);
            if ("hit".equals(result)) {
                break;
            }
            if ("kill".equals(result)) {
                /* 如果击沉一个DotCom，则删除该元素。注意集合的for循环中remove可能会报错，但是这种remove完就跳出循环，
                * 不继续循环的话，不会报错。下次进该方法，集合已经是两个元素的，不会报错 */
                dotcomsList.remove(dotCom);
                break;
            }
        }
        System.out.println(result);
    }

    private void finishGame() {
        System.out.println("All Dot Com are dead! Your stock is now worthless.");
        if (numOfGuesses <= 18) {
            System.out.println("It only took you " + numOfGuesses + " guesses.");
            System.out.println("You got out before your options sank.");
        } else {
            System.out.println("Took you long enough. " + numOfGuesses + " guesses.");
            System.out.println("Fish are dancing with your options.");
        }
    }

    public static void main(String[] args) {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }

}
