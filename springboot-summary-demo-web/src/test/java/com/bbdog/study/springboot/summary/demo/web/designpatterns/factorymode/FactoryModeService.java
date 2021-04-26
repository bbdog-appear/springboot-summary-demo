package com.bbdog.study.springboot.summary.demo.web.designpatterns.factorymode;

import com.bbdog.study.springboot.summary.demo.web.designpatterns.factorymode.enums.BootRewardTypeEnum;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * <p>
 *      工厂模式调用Service类
 *      1、如果这里不用枚举去获取真正的业务类，那么这里需要用if else判断是哪种类型，然后去new一个真正的业务对象去调用factoryModeBiz#sendReward方法
 *      2、通过枚举只是获取到Class对象，那么可以通过spring去拿到容器中的业务bean。
 *      BootInterface<?, ?> bootInterface = (BootInterface<?, ?>) applicationContext.getBean(rewardTypeClass);
 *      这段代码其实就是和@Autowired private BootInterface bootInterface;差不多，只不过这里通过枚举指定了是哪个业务类，Autowired可以通过名字指定
 *      3、这里也用到了回调的思想，把接口的实现类丢进Biz的方法入参里，调用biz方法其实是调用这个接口实现类的方法。
 *      4、那么回调可以这么做：定义一个接口后，实现类是另一个人写，然后把这里该写的都写好。当实现类被别人实现时，并重写里面的方法，比如BootCoupon
 *      类中的sendReward(CouponModel data, String message)方法。当别人这个实现类丢进去Biz中，他默认就知道会调用sendReward方法，并且
 *      入参的data，message都已经被赋值了。
 * </p>
 *
 * @author cheng.wang
 * @version Id：FactoryModeService.java Date：2021/4/26 19:05 Version：1.0
 */
@Component
public class FactoryModeService implements ApplicationContextAware {

    private ApplicationContext applicationContext;
    @Autowired
    private FactoryModeBiz factoryModeBiz;

    public void sendReward (String rewardType) {
        Class<?> rewardTypeClass = BootRewardTypeEnum.getRewardTypeClass(rewardType);
        BootInterface<?, ?> bootInterface = (BootInterface<?, ?>) applicationContext.getBean(rewardTypeClass);
        factoryModeBiz.sendReward(bootInterface);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
