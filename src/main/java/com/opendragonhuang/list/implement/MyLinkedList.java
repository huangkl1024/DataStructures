package com.opendragonhuang.list.implement;

import com.opendragonhuang.list.adt.MyList;
import com.opendragonhuang.list.exception.MyListIsEmptyException;

import java.util.Iterator;

/**
 * 双向链表。
 * @author opendragonhuang
 * @version 1.0
 * @date 2019/8/4
 */
public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {
    private class ListNode{
        T value;
        ListNode next;
        ListNode pre;
    }

    private ListNode head;
    private ListNode tail;
    private int length;

    public MyLinkedList() {
        head = new ListNode();
        tail = head;
    }

    /**
     * 清空线性表。
     */
    @Override
    public void clear() {
        head.next = null;
        tail = head;
        length = 0;
    }

    /**
     * 判断线性表是否为空，为空返回 true，不为空返回 false。
     *
     * @return
     */
    @Override
    public boolean empty() {
        return length == 0;
    }

    /**
     * 返回线性表的长度。
     *
     * @return
     */
    @Override
    public int length() {
        return length;
    }

    /**
     * 获取线性表第 i 个位置的数据元素。
     *
     * @param i
     * @return
     */
    @Override
    public T getElem(int i) {
        if(i < 1 || i > length){
            throw new IndexOutOfBoundsException("传入的索引超出了线性表的长度");
        }

        return _getElem(i).value;
    }

    /**
     * 返回线性表第一个与数据元素 e 相等的数据元素的位置。
     *
     * @param e
     * @return
     */
    @Override
    public int locateElem(T e) {
        ListNode p = head.next;
        int i = 1;
        while (p != null){
            if(p.value.compareTo(e) == 0){
                return i;
            }
            p = p.next;
            i++;
        }

        return 0;
    }

    /**
     * 返回与线性表中与数据元素 curElem 相等的数据元素的前驱。
     *
     * @param curElem
     * @return
     */
    @Override
    public T preElem(T curElem) {
        int i = locateElem(curElem);

        if(i == 1 || i == 0){
            return null;
        }else{
            return _locateElem(curElem).pre.value;
        }
    }

    /**
     * 返回与线性表中与数据元素 curElem 相等的数据元素的后继。
     *
     * @param curElem
     * @return
     */
    @Override
    public T nextElem(T curElem) {
        int i = locateElem(curElem);

        if(i == length || i == 0){
            return null;
        }else{
            return _locateElem(curElem).next.value;
        }
    }

    /**
     * 往线性表第 i 位置插入元素。
     *
     * @param i
     * @param e
     */
    @Override
    public void insert(int i, T e) {
        if(i < 1 || i > length+1){
            throw new IndexOutOfBoundsException("传入的索引超出了线性表的长度");
        }
        ListNode p = _getElem(i-1);
        ListNode node = new ListNode();
        node.value = e;

        if(i == length+1){
            node.pre = p;
            node.next = p.next;
            p.next = node;
            tail = node;
        }else{
            node.next = p.next;
            node.pre = p;
            p.next.pre = node;
            p.next = node;
        }

        length++;
    }

    /**
     * 删除线性表第 i 位置的元素。
     *
     * @param i
     * @return
     */
    @Override
    public T delete(int i) throws MyListIsEmptyException {

        if(i < 1 || i > length){
            throw new IndexOutOfBoundsException("传入的索引超出了线性表的长度");
        }

        ListNode p = _getElem(i);
        T e = p.value;
        if(i == length){
            p.pre.next = null;
            tail = p.pre;
        }else{
            p.pre.next = p.next;
            p.next.pre = p.pre;
        }
        length--;
        return e;
    }

    /**
     * 遍历顺序表。
     */
    @Override
    public void traverse() {
        for(T t : this){
            System.out.print(t+"\t");
        }
        System.out.println();
    }

    /**
     * 克隆顺序表。
     *
     * @return
     */
    @Override
    public MyList<T> clone() {
        MyLinkedList<T> linkedList = null;
        try {
            linkedList = (MyLinkedList<T>) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return linkedList;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyLinkedListIterator();
    }

    private ListNode _getElem(int i){
        ListNode p = null;
        if(i <= length/2){
            p = head;
            int j = 0;
            while(j < i){
                p = p.next;
                j++;
            }
        }else{
            p = tail;
            int j = length;
            while (j > i){
                p = p.pre;
                j--;
            }
        }

        return p;
    }

    private ListNode _locateElem(T e){
        ListNode p = head.next;
        while (p != null){
            if(p.value.compareTo(e) == 0){
                return p;
            }
            p = p.next;
        }

        return null;
    }

    private class MyLinkedListIterator implements Iterator<T>{
        ListNode p = head.next;

        @Override
        public boolean hasNext() {
            return p != null;
        }

        @Override
        public T next() {
            T e = p.value;
            p = p.next;
            return e;
        }

        @Override
        public void remove() {

        }
    }
}
