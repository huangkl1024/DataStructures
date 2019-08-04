package com.opendragonhuang.list.implement;

import org.junit.Test;

public class MyStaticSingleLinkedListTest {
    private MyStaticSingleLinkedList<Integer> myStaticList = new MyStaticSingleLinkedList<>();

    @Test
    public void insert() {
        for (int i = 1; i < 10; i++) {
            myStaticList.insert(i, i);
        }
        System.out.println("free Memory："+myStaticList.getFreeMemory());
        myStaticList.traverse();
        System.out.println("第 5 为：" + myStaticList.getElem(5));
        System.out.println("值为 6 的位置为："+myStaticList.locateElem(6));
        System.out.println("1的前驱为："+myStaticList.preElem(1));
        System.out.println("9 的后继为："+myStaticList.nextElem(9));
        System.out.println("5 的前驱和后继为："+myStaticList.preElem(5)+","+myStaticList.nextElem(5));
        for (int i = 1; i < 5; i++) {
            myStaticList.delete(1);
        }
        System.out.println("free Memory："+myStaticList.getFreeMemory());
        myStaticList.traverse();
        myStaticList.clear();
        myStaticList.traverse();
        System.out.println("free Memory："+myStaticList.getFreeMemory());
    }
}