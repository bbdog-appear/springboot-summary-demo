package com.bbdog.study.springboot.summary.demo.web.javabase.headfirstjava.dotcom;

import lombok.Data;

/**
 * <p>
 *      模拟攻击网站小游戏(猜测位置打掉计算机所安排的达康公司 dot com网站)
 *      1、但是这个checkYourself有个小bug，就是玩家三次猜的同一个位置，都会击中。所以需要改进一下：
 *      判别之前是否已经被猜中。
 * </p>
 *
 * @author cheng.wang
 * @version Id：SimpleDotCom.java Date：2021/12/20 18:42 Version：1.0
 */
@Data
public class SimpleDotCom {

    /**
     * 代表DotCom占据的位置
     */
    private int[] locationCells;
    /**
     * 命中DotCom(网站)数，命中3次游戏结束
     */
    private int numOfHits;

    /**
     * 伪代码
     * 该方法需要被优化。方法名就暂时改为Deprecated
     *
     * @param guess 校验结果
     * @return 结果
     */
    @Deprecated
    public String checkYourself(String guess) {
        int intGuess = Integer.parseInt(guess);
        String result = "miss";

        for (int cell : locationCells) {
            if (cell == intGuess) {
                result = "hit";
                numOfHits++;
                break;
            }
        }
        if (numOfHits == locationCells.length) {
            result = "kill";
        }
        System.out.println(result);
        return result;
    }

    /**
     * 放DotCom数组
     *
     * @param loc DotCom数组
     */
    public void setLocationCells(int[] loc) {
        locationCells = loc;
    }

}
