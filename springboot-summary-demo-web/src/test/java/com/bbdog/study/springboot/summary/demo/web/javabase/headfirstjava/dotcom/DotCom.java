package com.bbdog.study.springboot.summary.demo.web.javabase.headfirstjava.dotcom;

import lombok.Data;

import java.util.ArrayList;

/**
 * <p>
 *      攻击网站小游戏升级版(优化版)，原来的版本有小bug，类名：SimpleDotCom
 *      1、在命中某个格子时就把它删除掉，但是数组无法改变大小，因此必须做出新的数组并拷贝旧数组的值，比如数组的值是4 5 6，命中5时，就拷贝
 *      剩余的4 6到新的数组中。但是还是太麻烦。如果能找到一种数组会在删除某些元素时自动缩小就行了。
 *      2、那么ArrayList就是这样的集合，有上述这样的功能。
 *      3、ArrayList不能直接存int等基本类型，但是可以把这种primitive主数据类型包装起来。
 * </p>
 *
 * @author cheng.wang
 * @version Id：DotCom.java Date：2022/1/4 18:56 Version：1.0
 */
@Data
public class DotCom {

    /**
     * 代表DotCom占据的位置
     */
    private ArrayList<String> locationCells;
    /**
     * DotCom的名称
     */
    private String name;

    /**
     * 猜测格子位置并返回结果
     *
     * @param userInput 用户输入值
     * @return 结果
     */
    public String checkYourself(String userInput) {
        String result = "miss";
        // 返回此列表中指定元素第一次出现的索引，如果此列表不包含该元素，则返回 -1
        int index = locationCells.indexOf(userInput);
        // 如果索引值大于等于0，命中!
        if (index >= 0) {
            result = "hit";
            // 移除此列表中指定位置的元素。将任何后续元素向左移动（从它们的索引中减去一个）
            locationCells.remove(index);
            // 如果此列表不包含任何元素，则返回 <tt>true<tt>
            if (locationCells.isEmpty()) {
                result = "kill";
                System.out.println("Ouch! You sunk " + name + " : (");
            }
        }
        return result;
    }

    /**
     * 放DotCom的集合
     *
     * @param loc DotCom集合
     */
    public void setLocationCells(ArrayList<String> loc) {
        locationCells = loc;
    }

}
