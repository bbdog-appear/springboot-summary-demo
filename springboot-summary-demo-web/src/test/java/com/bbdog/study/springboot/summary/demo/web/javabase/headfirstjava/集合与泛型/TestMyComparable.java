package com.bbdog.study.springboot.summary.demo.web.javabase.headfirstjava.集合与泛型;

import com.bbdog.study.springboot.summary.demo.web.javabase.heimastudy.排序.Employee;
import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author cheng.wang
 * @version Id：TestMyComparable.java Date：2022/11/8 16:39 Version：1.0
 */
@Data
public class TestMyComparable implements Comparable<Employee> {

    @Override
    public int compareTo(Employee o) {
        return 0;
    }



}
