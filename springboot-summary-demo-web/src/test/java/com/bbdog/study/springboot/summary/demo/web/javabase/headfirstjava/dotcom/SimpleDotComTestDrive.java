package com.bbdog.study.springboot.summary.demo.web.javabase.headfirstjava.dotcom;

/**
 * <p>
 *      攻击网站小游戏测试类
 * </p>
 *
 * @author cheng.wang
 * @version Id：SimpleDotComTestDrive.java Date：2021/12/20 19:52 Version：1.0
 */
public class SimpleDotComTestDrive {

    public static void main(String[] args) {
        // 记录玩家猜测次数
        int numOfGuesses = 0;
        GameHelper helper = new GameHelper();

        // 初始化对象
        SimpleDotCom dot = new SimpleDotCom();
        // Math.random()返回一个介于0~1之间的数，公式返回0~4之间的整数
        int randomNum = (int) (Math.random() * 5);

        // 创建一个带有dom com位置的数组
        int[] locations = {randomNum, randomNum + 1, randomNum + 2};
        dot.setLocationCells(locations);
        boolean isAlive = true;

        while (isAlive) {
            // 取得玩家输入的字符串
            String guess = helper.getUserInput("enter a number");
            String result = dot.checkYourself(guess);
            numOfGuesses++;
            if ("kill".equals(result)) {
                isAlive = false;
                System.out.println("You took " + numOfGuesses + " guesses");
            }
        }
    }

}
