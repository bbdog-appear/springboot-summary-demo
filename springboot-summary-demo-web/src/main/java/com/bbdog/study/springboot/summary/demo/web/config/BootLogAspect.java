package com.bbdog.study.springboot.summary.demo.web.config;

import com.bbdog.study.springboot.summary.demo.common.annotation.BootLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * <p>
 *      日志切面(自定义注解版)
 *      1、Aspect注解声明这是一个切面，Component意思将被spring管理
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootLogAspect.java Date：2021/5/6 19:47 Version：1.0
 */
@Slf4j
@Aspect
@Component
public class BootLogAspect {

    /**
     * 表示这个切点切到一个注解上，即哪个方法使用该注解，就切到这个方法上。
     */
    @Pointcut("@annotation(com.bbdog.study.springboot.summary.demo.common.annotation.BootLog)")
    void logPointCut(){}

    @Around("logPointCut()")
    Object logAround(ProceedingJoinPoint joinPoint){
        // 类名
        String clazzName = joinPoint.getTarget().getClass().getName();
        // 获取方法名称
        String methodName = joinPoint.getSignature().getName();
        // 获取入参
        Object[] params = joinPoint.getArgs();
        // 获取注解
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        BootLog annotation = signature.getMethod().getAnnotation(BootLog.class);

        log.info("{},进入[{}#{}]方法,参数为[{}]", annotation.value(), clazzName, methodName, params);
        Object proceed = null;
        try {
            proceed = joinPoint.proceed();
        } catch (Throwable e) {
            log.error("{}系统异常", annotation.value());
        }
        log.info("{},[{}#{}]方法执行结束", annotation.value(), clazzName, methodName);
        return proceed;
    }

}
