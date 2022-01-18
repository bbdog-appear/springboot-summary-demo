package com.bbdog.study.springboot.summary.demo.web.javabase.headfirstjava.构造器与垃圾回收;

import java.util.ArrayList;

/**
 * <p>
 *      能源消耗问题
 *      V2Radiator类的构造函数会取用一个ArrayList参数，这代表每次V3Radiator的构造函数被调用时，他会在对V2Radiator的super()调用中
 *      传入一个ArrayList。这样会额外多出5个V2Radiator的SimUnit。如此一来，总体能源消耗会是120而不是秋香预测的100。
 * </p>
 *
 * @author cheng.wang
 * @version Id：TestLifeSupportSim.java Date：2022/1/18 10:15 Version：1.0
 */
public class TestLifeSupportSim {
    public static void main(String[] args) {
        ArrayList aList = new ArrayList();
        V2Radiator v2 = new V2Radiator(aList);
        V3Radiator v3 = new V3Radiator(aList);
        for (int z = 0; z < 20; z++) {
            RetentionBot ret = new RetentionBot(aList);
        }
    }
}

class V2Radiator {
    V2Radiator(ArrayList list) {
        for (int x = 0; x < 5; x++) {
            list.add(new SimUnit("V2Radiator"));
        }
    }
}

class V3Radiator extends V2Radiator {
    V3Radiator(ArrayList list) {
        super(list);
        for (int g = 0; g < 10; g++) {
            list.add(new SimUnit("V3Radiator"));
        }
    }
}

class RetentionBot {
    RetentionBot(ArrayList list) {
        list.add(new SimUnit("Retention"));
    }
}

class SimUnit {
    String botType;

    SimUnit(String type) {
        botType = type;
    }

    int powerUse() {
        if ("Retention".equals(botType)) {
            return 2;
        } else {
            return 4;
        }
    }
}
