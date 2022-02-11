package com.bbdog.study.springboot.summary.demo.web.javabase.heimastudy.排序;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * <p>
 *      测试TreeSet 排序不重复集合
 *      1、有值特性的元素直接可以升序排序，字符串类型的元素会按照首字符的编号排序，对于自定义的引用类型，treeSet默认无法排序，执行的时候直接
 *        报错，因为它不知道排序规则。
 *      2、自定义引用类型数据的排序实现：
 *        a.直接为对象实现比较器规则接口Comparable，重写比较方法
 *          如果程序员认为比较者大于被比较者 返回正数
 *          如果程序员认为比较者小于被比较者 返回负数
 *          如果程序员认为比较者等于被比较者 返回0
 *        b.直接为集合设置比较器Comparator对象，重写比较方法
 *          如果程序员认为比较者大于被比较者 返回正数
 *          如果程序员认为比较者小于被比较者 返回负数
 *          如果程序员认为比较者等于被比较者 返回0
 * </p>
 *
 * @author cheng.wang
 * @version Id：TestTreeSet.java Date：2022/2/11 9:44 Version：1.0
 */
public class TestTreeSet {

    public static void main(String[] args) {
        Set<Double> set = new TreeSet<>();
        set.add(34.02);
        set.add(7.26);
        set.add(3.77);
        set.add(108.25);
        set.add(199.09);
        set.add(27.11);
        // [3.77, 7.26, 27.11, 34.02, 108.25, 199.09]
        System.out.println(set);
        Set<String> set1 = new TreeSet<>();
        set1.add("jack");
        set1.add("rose");
        set1.add("george");
        set1.add("boNiu");
        set1.add("NiuNiu");
        set1.add("佩奇");
        set1.add("cj");
        // [NiuNiu, boNiu, cj, george, jack, rose, 佩奇]
        System.out.println(set1);
        // 第2种方式，为集合的构造函数添加Comparator的匿名内部类，重写compare方法
        Set<Employee> set2 = new TreeSet<>(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o2.getAge() - o1.getAge();
            }
        });
        set2.add(new Employee("波仔", 6500.00, 21));
        set2.add(new Employee("波妞", 7500.00, 19));
        set2.add(new Employee("乔治", 4500.00, 23));
        // 如果既有对象实现Comparable，又有集合添加Comparator的匿名内部类，则优先级是使用集合的这个Comparator的匿名内部类。
        // 倒序排序:[Employee(name=乔治, salary=4500.0, age=23), Employee(name=波仔, salary=6500.0, age=21), Employee(name=波妞, salary=7500.0, age=19)]
        System.out.println(set2);
    }

}
