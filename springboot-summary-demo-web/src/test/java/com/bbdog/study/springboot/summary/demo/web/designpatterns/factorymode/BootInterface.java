package com.bbdog.study.springboot.summary.demo.web.designpatterns.factorymode;

/**
 * <p>
 *      定义接口(测试工厂模式)-工厂模式分为简单工厂模式和抽象工厂模式。
 *      简单工厂模式就是工厂类里简单的用key获取bean，抽象工厂模式用代理的方式去获取真正执行的业务bean。
 *      那么这里的话，可以用枚举的方式，用code获取业务bean或者Class对象，然后用回调的方式完成真正的调用。不用对于不同的业务写那么多if else了
 *      1、定义一个接口，方法一为发放奖励，但是奖励的方式有很多，所以具体方法由各自的业务去实现，由于方法入参也未知，所以可以通过类名泛型的方式传入(方法中也可以定义泛型)
 *      2、对于不同的业务实现类，实现该接口时可以指定T和D的类型，那么重写方法中也会自动对应相同的类型。
 *      3、使用场景：如果不同的业务做着同一类事，但是具体的内容不同，则可以定义接口去规范他们。
 *      4、这里也可以定义一个抽象类，因为在枚举获取class的时候，需要Class<? extends AbsClass>然后才能返回相应的类型，接口就不行
 *      5、实现该接口的实现类，如果想通过application去获取的话，需要加@Component注解，才能被Spring管理
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootInterface.java Date：2021/4/26 17:26 Version：1.0
 */
public interface BootInterface<T, D> {

    /**
     * 发放奖励
     *
     * @param data 数据
     * @param message 消息
     */
    void sendReward(T data, D message);

    /**
     * 获取数据
     *
     * @return 数据data
     */
    T createData();

    /**
     * 获取日志
     *
     * @return 日志号
     */
    D createMessage();

    /**
     * 获取类的class对象
     *
     * @return class对象
     */
    Class<T> getClassObject();

}
