package com.opendragonhuang.list.adt;

import com.opendragonhuang.list.exception.MyListIsEmptyException;

import java.util.Iterator;

/**
 * @author opendragonhuang
 * @version 1.0
 * @date 2019/8/3
 */
public interface MyList<T extends Comparable<T>> extends Cloneable, Iterable<T> {
    /**
     * 清空线性表。
     */
    void clear();

    /**
     * 判断线性表是否为空，为空返回 true，不为空返回 false。
     * @return
     */
    boolean empty();

    /**
     * 返回线性表的长度。
     * @return
     */
    int length();

    /**
     * 获取线性表第 i 个位置的数据元素。
     * @param i
     * @return
     */
    T getElem(int i);

    /**
     * 返回线性表第一个与数据元素 e 相等的数据元素的位置。
     * @param e
     * @return
     */
    int locateElem(T e);

    /**
     * 返回与线性表中与数据元素 curElem 相等的数据元素的前驱。
     * @param curElem
     * @return
     */
    T preElem(T curElem);

    /**
     * 返回与线性表中与数据元素 curElem 相等的数据元素的后继。
     * @param curElem
     * @return
     */
    T nextElem(T curElem);

    /**
     * 往线性表第 i 位置插入元素。
     * @param i
     * @param e
     */
    void insert(int i, T e);

    /**
     * 删除线性表第 i 位置的元素。
     * @param i
     * @return
     */
    T delete(int i) throws MyListIsEmptyException;

    /**
     * 遍历顺序表。
     */
    void traverse();

    /**
     * 克隆顺序表。
     * @return
     */
    MyList<T> clone();
}
