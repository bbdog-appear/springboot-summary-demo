package com.bbdog.study.springboot.summary.demo.web.javabase.headfirstjava.dotcom;

import java.util.ArrayList;

/**
 * <p>
 *      测试小游戏的公共扩展知识
 * </p>
 *
 * @author cheng.wang
 * @version Id：CommonExpand.java Date：2022/1/4 18:51 Version：1.0
 */
public class CommonExpand {

    public static void main(String[] args) {
//        testArrayList();
//        testArrayListRemove();
        testArrayListEmpty();
    }

    /**
     * 测试ArrayList中方法isEmpty();
     */
    private static void testArrayListEmpty() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(null);
        arrayList.add(null);
        arrayList.add(13);
        arrayList.add(null);
        /* 移除此列表中指定位置的元素。将任何后续元素向左移动（从它们的索引中减去一个） */
        arrayList.remove(2);
        /* 如果此列表不包含任何元素，则返回 <tt>true<tt>，虽然上述列表中最终只有3个null值，但是元素的个数还是3，即null也是元素 */
        boolean empty = arrayList.isEmpty();
        /* 打印出：
        * [null, null, null]
          false
        *  */
        System.out.println(arrayList + "\n" + empty);
    }

    /**
     * 测试ArrayList中方法remove(int index);
     */
    private static void testArrayListRemove() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(null);
        arrayList.add(11);
        arrayList.add(null);
        arrayList.add(12);
        arrayList.add(13);
        arrayList.add(14);
        arrayList.add(null);
        arrayList.add(2, 10);
        arrayList.add(5, 30);
        arrayList.add(1, 5);
        /* 移除此列表中指定位置的元素。将任何后续元素向左移动（从它们的索引中减去一个） */
        arrayList.remove(1);

        System.out.println(arrayList);
    }

    /**
     * 测试ArrayList中方法add(int index, E element);
     */
    private static void testArrayList() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(11);
        arrayList.add(12);
        arrayList.add(13);
        arrayList.add(14);
        /* 使用list.add(int index, E element);时注意，有个size的校验，这个size是元素的大小，如果前面不添加
         * 元素，那么集合中元素个数也就是size就是0，那么add(int index, E element)超过这个位置添加元素，则会报错，
         * 同时在第2个位置添加元素，那么本来第2个元素及后面的元素都会往后移动一位，并不是覆盖，而是插队。即：11 12 10 13 14 */
        arrayList.add(2, 10);
        arrayList.add(5, 30);
        arrayList.add(1, 5);
        System.out.println(arrayList);
    }

}
