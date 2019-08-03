package com.opendragonhuang.list.example;

import com.opendragonhuang.list.adt.MyList;
import com.opendragonhuang.list.implement.MyArrayList;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListsTest {

    @Test
    public void mergeList() {
        MyArrayList<Integer> list1 = new MyArrayList<>();
        for (int i = 1; i < 20; i++) {
            list1.insert(i, i);
        }
        System.out.println("list1 的值为：");
        list1.traverse();

        MyArrayList<Integer> list2 = new MyArrayList<>();
        for (int i = 20; i < 40; i++) {
            list2.insert(i-19, i);
        }
        System.out.println("list2 的值为：");
        list2.traverse();

        MyList<Integer> list = Lists.MergeList(list1, list2);
        System.out.println("list 的值为：");
        list.traverse();

    }

    @Test
    public void unionList() {
        MyArrayList<Integer> list1 = new MyArrayList<>();
        for (int i = 1; i < 20; i++) {
            list1.insert(i, i);
        }
        System.out.println("list1 的值为：");
        list1.traverse();

        MyArrayList<Integer> list2 = new MyArrayList<>();
        for (int i = 1; i < 10; i++) {
            list2.insert(i, i);
        }
        for (int i = 10; i < 15; i++) {
            list2.insert(i, i*3);
        }
        System.out.println("list2 的值为：");
        list2.traverse();

        MyList<Integer> list = Lists.UnionList(list1, list2);
        System.out.println("list 的值为：");
        list.traverse();
    }
}