package com.bbdog.study.springboot.summary.demo.web.javabase.headfirstjava.构造器与垃圾回收.实例变量;

/**
 * <p>
 *     如果局部变量(方法中的变量)生存在栈上，那么实例变量(成员变量)呢，分析如下：
 *      其中a是实例变量，对象的实例变量的值是存放在该对象中。
 *      1、如果实例变量全都是primitive主数据类型的，则java会依据primitive主数据类型的大小为该实例变量
 *        留下空间。int需要32位，long需要64位，以此类推。java并不在乎私有变量的值，不管是32或32000000的int都会占用32位。
 *      2、如果实例变量是个对象，也就是说CellPhone带有Antenna类型的引用变量。
 *          2.1、如果一个新建对象带有对象引用的变量时，是否需要保留对象带有的所有对象的空间？不是这样的。无论如何，Java会留下空间给
 *              实例变量的值。但是引用变量的值并不是对象本身，所以当CellPhone带有Antenna，java只会留下Antenna引用量而不是对象本身
 *              所用到的空间。
 *          2.2、Antenna对象会取得在堆上的空间吗？这要看实例变量是如何声明的。如果有声明变量但没有给它赋值，则只会留下变量的空间：
 *              private Antenna ant;直到引用变量被赋值一个新的Antenna对象才会在堆上占有空间：private Antenna ant = new Antenna();
 *          2.3、实例变量保存在所属的对象中，位于堆上。
 *          2.4、如果实例变量是个对对象的引用，则引用与对象都是在堆中。
 *      3、在创建对象时(完全没有其他方法能够创建对象，只能通过new来产生新对象)，对象会取得所有实例变量所需的空间，这当然会包括一路继承下来的东西。
 *        父类也许会有一个setter以包装私用的变量。但此变量必须有空间(父类ElectricalAppliances的变量)。对象就像洋葱是有层次的，每一层都代表
 *        某一级的父类。
 * </p>
 *
 * @author cheng.wang
 * @version Id：CellPhone.java Date：2022/1/12 18:41 Version：1.0
 */
public class CellPhone extends ElectricalAppliances{

    private int a;

    private Antenna ant = new Antenna();

}
