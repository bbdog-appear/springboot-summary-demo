package com.bbdog.study.springboot.summary.demo.web.javabase.headfirstjava.继承和多态.练习2;

/**
 * <p>
 *      测试多态，父类引用指向子类对象。同一个行为具有多个不同表现形式或形态的能力
 *      怪物类都有相似的行为，但是子类有不同的具体表现。
 *      可以解耦，比如在新增一个子类，只需要继承父类并重写方法即可。不需要改动原来的代码。
 * </p>
 *
 * @author cheng.wang
 * @version Id：MonsterTestDrive.java Date：2022/1/7 14:37 Version：1.0
 */
public class MonsterTestDrive {

    public static void main(String[] args) {
        Monster[] ma = new Monster[3];
        ma[0] = new Vampire();
        ma[1] = new Dragon();
        ma[2] = new Monster();
        for (int x = 0; x < 3; x++) {
            ma[x].frighten(x);
        }
    }

}

class Monster {
    boolean frighten(int d) {
        System.out.println("arrRgh");
        return true;
    }
}

class Vampire extends Monster {
    @Override
    boolean frighten(int d) {
        System.out.println("a bite?");
        return false;
    }
}

class Dragon extends Monster {
    @Override
    boolean frighten(int degree) {
        System.out.println("breath fire");
        return true;
    }
}
