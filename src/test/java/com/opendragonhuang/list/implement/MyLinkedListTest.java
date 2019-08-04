package com.opendragonhuang.list.implement;

import com.opendragonhuang.list.adt.MyList;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyLinkedListTest {
    private MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();

    @Test
    public void insert() {
        for (int i = 1; i <= 10; i++) {
            myLinkedList.insert(i, i);
        }
        myLinkedList.traverse();
        System.out.println("第 5 为：" + myLinkedList.getElem(5));
        System.out.println("值为 6 的位置为："+myLinkedList.locateElem(6));
        System.out.println("1的前驱为："+myLinkedList.preElem(1));
        System.out.println("10 的后继为："+myLinkedList.nextElem(10));
        System.out.println("5 的前驱和后继为："+myLinkedList.preElem(5)+","+myLinkedList.nextElem(5));
        myLinkedList.insert(1, 100);
        myLinkedList.insert(12, 200);
        myLinkedList.traverse();
        for (int i = 1; i <= 5; i++) {
            myLinkedList.delete(1);
        }
        myLinkedList.traverse();
        myLinkedList.clear();
        myLinkedList.traverse();
    }
}