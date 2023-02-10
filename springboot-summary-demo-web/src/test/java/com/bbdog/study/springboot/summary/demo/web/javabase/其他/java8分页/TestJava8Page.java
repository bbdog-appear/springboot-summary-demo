package com.bbdog.study.springboot.summary.demo.web.javabase.其他.java8分页;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *
 * </p>
 *
 * @author cheng.wang
 * @version Id：TestJava8Page.java Date：2023/2/10 13:54 Version：1.0
 */
public class TestJava8Page {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 102; i++) {
            list.add(i);
        }

        int currentPage = 1;
        int pageSize = 20;
        int count = list.size() % pageSize == 0 ? list.size() / pageSize : list.size() / pageSize + 1;
        for (int i = 0; i < count; i++) {
            List<Integer> collect = list.stream().skip((long) (currentPage - 1) * pageSize).limit(pageSize).collect(Collectors.toList());
            System.out.println(collect);
            currentPage++;
        }
    }

}
