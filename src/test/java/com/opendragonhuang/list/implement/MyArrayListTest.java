package com.opendragonhuang.list.implement;

import org.junit.Test;

public class MyArrayListTest {

    @Test
    public void clear() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        for (int i = 1; i < 20; i++) {
            myArrayList.insert(i, i);
        }
        myArrayList.traverse();
        System.out.println("length:"+myArrayList.length());
        myArrayList.clear();
        myArrayList.traverse();
        System.out.println("length:"+myArrayList.length());
    }

    @Test
    public void getElem() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        for (int i = 1; i < 20; i++) {
            myArrayList.insert(i, i);
        }
        for (int i = 1; i < 20; i++) {
            System.out.println("第"+i+"个数据元素："+myArrayList.getElem(i)+"\t");
        }
    }

    @Test
    public void locateElem() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        for (int i = 1; i < 20; i++) {
            myArrayList.insert(i, i);
        }
        System.out.println("元素 12 的位置为："+myArrayList.locateElem(12));
    }

    @Test
    public void priorElemAndnextElem() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        for (int i = 1; i < 20; i++) {
            myArrayList.insert(i, i);
        }
        System.out.println("元素 12 的前驱为："+myArrayList.preElem(12));
        System.out.println("元素 12 的后继为："+myArrayList.nextElem(12));
        System.out.println("元素 1 的前驱为："+myArrayList.preElem(1));
        System.out.println("元素 19 的后继为："+myArrayList.nextElem(19));
    }

    @Test
    public void insert() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        for (int i = 1; i < 20; i++) {
            myArrayList.insert(i, i);
        }
        myArrayList.traverse();
        System.out.println("length:"+myArrayList.length());
    }

    @Test
    public void delete() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        for (int i = 1; i < 20; i++) {
            myArrayList.insert(i, i);
        }
        myArrayList.traverse();
        System.out.println("length:"+myArrayList.length());

        for (int i = 1; i < 11; i++) {
            myArrayList.delete(1);
        }
        myArrayList.traverse();
        System.out.println("length:"+myArrayList.length());
        for (int i = 1; i < 11; i++) {
            myArrayList.delete(1);
        }
    }
}