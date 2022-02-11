package com.bbdog.study.springboot.summary.demo.web.javabase.heimastudy.排序;

import lombok.Data;

/**
 * <p>
 *      实现Comparable接口，treeSet集合排序时会根据执行该重写方法的比较规则进行排序。
 * </p>
 *
 * @author cheng.wang
 * @version Id：Employee.java Date：2022/2/11 10:27 Version：1.0
 */
@Data
public class Employee implements Comparable<Employee>{

    private String name;
    private double salary;
    private int age;

    public Employee() {
    }

    public Employee(String name, double salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public int compareTo(Employee o) {
//        if (this.age > o.age) {
//            return 1;
//        } else if (this.age < o.age) {
//            return -1;
//        }
        // 优雅式代码
        return this.age - o.age;
    }

}
