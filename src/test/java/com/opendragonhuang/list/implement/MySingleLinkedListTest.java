package com.opendragonhuang.list.implement;

import org.junit.Test;

import static org.junit.Assert.*;

public class MySingleLinkedListTest {
    private MySingleLinkedList<Integer> mySingleLinkedList = new MySingleLinkedList<>();

    @Test
    public void insert() {
        for (int i = 1; i < 10; i++) {
            mySingleLinkedList.insert(i, i);
        }
        mySingleLinkedList.traverse();
    }

    @Test
    public void delete() {
        for (int i = 1; i < 10; i++) {
            mySingleLinkedList.insert(i, i);
        }
        mySingleLinkedList.traverse();
        for (int i = 1; i < 5; i++) {
            mySingleLinkedList.delete(i);
        }
        mySingleLinkedList.traverse();
    }

    @Test
    public void locateElem() {
        for (int i = 1; i < 10; i++) {
            mySingleLinkedList.insert(i, i);
        }
        System.out.println("数据元素 7 的位置为："+mySingleLinkedList.locateElem(7));
    }

    @Test
    public void priorElemAndNextElem(){
        for (int i = 1; i < 10; i++) {
            mySingleLinkedList.insert(i, i);
        }
        System.out.println("数据元素 7 的前驱为："+mySingleLinkedList.priorElem(7));
        System.out.println("数据元素 7 的后继为："+mySingleLinkedList.nextElem(7));
        System.out.println("数据元素 1 的前驱为："+mySingleLinkedList.priorElem(1));
        System.out.println("数据元素 9 的后继为："+mySingleLinkedList.nextElem(9));
    }
}