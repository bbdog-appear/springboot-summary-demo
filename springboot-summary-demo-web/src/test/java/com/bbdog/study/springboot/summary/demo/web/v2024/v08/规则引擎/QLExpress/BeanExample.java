package com.bbdog.study.springboot.summary.demo.web.v2024.v08.规则引擎.QLExpress;

public class BeanExample {

    public static String upper(String abc) {
        return abc.toUpperCase();
    }

    public boolean anyContains(String str, String searchStr) {
        char[] s = str.toCharArray();
        for (char c : s) {
            if (searchStr.contains(c+"")) {
                return true;
            }
        }
        return false;
    }

}
