package com.bbdog.study.springboot.summary.demo.web.sourceTest.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *      测试通配符 ? 的作用
 * </p>
 *
 * @author cheng.wang
 * @version Id：AnimalTest.java Date：2021/3/31 18:11 Version：1.0
 */
public class AnimalTest {

    /**
     * 无通配符
     * 返回动物列表总共多少条腿
     *
     * @param animals 动物列表
     * @return 腿的条数
     */
    static Integer countLegs(List<BootAnimal> animals){
        Integer retVal = 0;
        for (BootAnimal bootAnimal : animals){
            retVal += bootAnimal.countLegs();
        }
        return retVal;
    }

    /**
     * 有通配符
     * 返回动物列表总共多少条腿
     *
     * @param animals 有通配符的动物列表
     * @return 腿的条数
     */
    static Integer countLegsWildcard(List<? extends BootAnimal> animals){
        Integer retVal = 0;
        for (BootAnimal bootAnimal : animals){
            retVal += bootAnimal.countLegs();
        }
        return retVal;
    }

    /**
     * 场景：有一个animal父类和几个子类，比如猫、狗、羊，现在需要计算出所有动物腿的条数。
     * 如果上面的方法参数不写成animal父类的话，就要在三个外部类中写三个方法，每个方法里调用每个子类的方法，其中每个子类做的事情不一样。
     * 优化代码的方式就是：只需要在一个外部类中写一个方法，方法里调用父类的方法，然后在调用外部类的这个方法时，传三个不同的子类就能和上面实现的功能一致，减少了代码量。
     *
     * 所以倒过来推：当需求中，不同类型的类，都需要做插入操作，但是每个类型的类的插入操作不同，就可以将这几个类型的类实现一个接口，或者继承一个父类(父类和接口的区别)。
     * 链接：https://blog.csdn.net/simon_it/article/details/80163241
     * 然后需要写一个外部类，写一个方法，方法参数是接口或者父类。如果不写接口或者父类，则需要写三个外部类或者一个外部类中，要写三个方法。
     *
     * 反例：比如之前写的一个需求，很多都需要封装调用限额累加接口的操作，但每个当中，该操作内容不同
     * 所以这些操作的类继承一个父类，写一个外部类，写一个方法，方法里调用父类的封装参数的操作，减少了代码量，注意因为这个操作是封装参数，是需要子类中成员变量
     * ，并不是调用子类的方法，所以这种场景不合适。
     *
     * 所以，当很多个不同的类，需要做同一类操作，操作内容不同，且操作内容里并不是要子类的成员变量(因为每个子类的成员变量不同)，就可以使用。
     * 比如之前不同的权益类型，都进行添加操作(同一类)，操作内容不同，且操作的内容是需要拿到子类的对象，并不是要子类对象的成员变量，而是要子类对象的方法进行调用，
     * 每个子类查询不同的数据库。所以这种可以配合工厂模式来使用。
     * 比如之前的不同的权益类型都需要申请操作，那么不同的权益类实现一个接口(注意这里不是继承)，并实现里面的方法。然后可以初始化一个map，把这些权益类型对象装到
     * map中，然后通过for循环，根据key获取value，即权益类型对象，然后只需要写一个外部类，写一个方法就行，for循环只要把这些权益类型对象传进去就行，类似回调函数。
     *
     *
     * 描述一下继承的好处：
     * 父类中有成员变量、方法。子类继承父类，可以继承父类的成员变量，重写父类的方法，同时子类可以加自己的成员变量、方法。
     * 继承的好处是，父类的方法，每个子类可以有不同的实现。如果想调用每个子类的方法，可以不用另外写几个调用子类的方法，
     * 只需要写一个就行，方法入参里写父类，方法里直接调用父类的方法。当真正调用时，传入哪个子类，就会执行哪个子类的方法。
     *
     * 当父类中只有成员变量时，继承的作用就是可以不用在每个子类中写重复的变量。
     * 当父类中只有方法时，继承的作用是不用写几个方法，分别调用子类方法，只需要写一个方法，
     *  方法参数中用父类，然后调用父类方法即可。
     *  如果参数为外部类中的成员变量时，即父类引用是外部类的成员变量，也可以直接调用父类方法。
     *  上面两种一种是局部变量，一种是成员变量，bean的生命周期不一样。
     *
     * 上述描述还是有点乱，看看即可。
     * 总结：同一类操作，单操作的内容不一样，比如发放这个类型的操作，但是可以发放优惠券、兑换券、实物。如果按照传统的写法，就是if else，如果类型是优惠券，那么就做发
     * 优惠券的操作。。。那么代码重构优化的话，可以用工厂模式，定义⼀个创建对象的接⼝，让其⼦类⾃⼰决定实例化哪⼀个⼯⼚类，⼯⼚模式使其创建过程延迟到⼦类进⾏。
     * 简单说就是为了提供代码结构的扩展性，屏蔽每⼀个功能类中的具体实现逻辑。让外部可以更加简单的只是知道调⽤即可，同时，这也是去掉众多 if else 的⽅式
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        List<BootDog> bootDogs = new ArrayList<>();
        // 编译报错
//        Integer countLegs = countLegs(bootDogs);
        // 加了通配符的不会报错
        Integer countLegsWildcard = countLegsWildcard(bootDogs);
        System.out.println(countLegsWildcard);
    }

}
