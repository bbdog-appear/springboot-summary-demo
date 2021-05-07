package com.bbdog.study.springboot.summary.demo.web.jvm.annotation;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * <p>
 *      注解的使用
 * </p>
 *
 * @author cheng.wang
 * @version Id：BootAnnotationUse.java Date：2021/4/29 16:16 Version：1.0
 */
@BootTable(tableName = "BootAnnotation")
@BootFruit("apple")
@Slf4j
public class BootAnnotationUse {

    @BootNoDbColumn(name = "用户名", defaultDbValue = true, fontColor = BootNoDbColumn.FontColor.BLUE, length = 12)
    private String bootName;

    @Test
    public void annotationUse() throws Exception {
//        Method annotationUse = BootAnnotationUse.class.getMethod("annotationUse", BootAnnotationUse.class);
//        BootTable bootTable = annotationUse.getAnnotation(BootTable.class);
//        bootTable.tableName();

        Class<BootAnnotationUse> clazz = BootAnnotationUse.class;
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(BootNoDbColumn.class)) {
                BootNoDbColumn annotation = field.getAnnotation(BootNoDbColumn.class);
                log.info("字段：{},描述：{},长度：{}", field.getName(), annotation.name(), annotation.length());
            }
        }
    }

}
