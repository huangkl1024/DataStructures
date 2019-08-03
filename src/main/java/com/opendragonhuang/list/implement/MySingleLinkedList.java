package com.opendragonhuang.list.implement;

import com.opendragonhuang.list.adt.MyList;
import com.opendragonhuang.list.exception.MyListIsEmptyException;

import java.util.Iterator;

/**
 * @author opendragonhuang
 * @version 1.0
 * @date 2019/8/3
 */
public class MySingleLinkedList<T extends Comparable<T>> implements MyList<T>, Iterable<T> {
    private class ListNode{
        T value;
        ListNode next;

        public ListNode() {
        }

        public ListNode(T value, ListNode next) {
            this.value = value;
            this.next = next;
        }
    }
    private ListNode head;
    private int length;

    public MySingleLinkedList() {
        head = new ListNode();
    }

    /**
     * 清空线性表。
     */
    @Override
    public void clear() {
        head.next = null;
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

        ListNode p = head;
        int i = 0;
        while (p.next != null){
            p = p.next;
            i++;
            if(p.value.compareTo(e) == 0){
                return i;
            }

        }

        return i;
    }

    /**
     * 返回与线性表中与数据元素 curElem 相等的数据元素的前驱。
     *
     * @param curElem
     * @return
     */
    @Override
    public T priorElem(T curElem) {
        ListNode p = head;
        while (p.next != null){
            if(p.next.value.compareTo(curElem) == 0){
                if( p == head){
                    return null;
                }else{
                    return p.value;
                }
            }
            p = p.next;
        }

        return null;
    }

    /**
     * 返回与线性表中与数据元素 curElem 相等的数据元素的后继。
     *
     * @param curElem
     * @return
     */
    @Override
    public T nextElem(T curElem) {
        ListNode p = head.next;
        while (p != null){
            if(p.value.compareTo(curElem) == 0){
                if(p.next == null){
                    return null;
                }else{
                    return p.next.value;
                }
            }
            p = p.next;
        }

        return null;
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
        ListNode tmp = new ListNode();
        tmp.value =  e;
        tmp.next = p.next;
        p.next = tmp;
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
        if(empty()){
            throw new IndexOutOfBoundsException("空表，无法删除");
        }
        if(i < 1 || i > length){
            throw new IndexOutOfBoundsException("传入的索引超出了线性表的长度");
        }

        ListNode p = _getElem(i-1);
        T e = p.next.value;
        p.next = p.next.next;
        length--;

        return e;
    }

    /**
     * 遍历顺序表。
     */
    @Override
    public void traverse() {
        for(T e : this){
            System.out.print(e+"\t");
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
        return null;
    }

    /**
     * 获取链表第 i 个位置的节点。
     * @param i
     * @return
     */
    private ListNode _getElem(int i){
        ListNode p = head;
        int j = 0;
        while (p != null && j < i){
            p = p.next;
            j++;
        }

        return p;
    }

    @Override
    public Iterator<T> iterator() {
        return new MySingleLinkedListIterator();
    }

    private class MySingleLinkedListIterator implements Iterator<T>{
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
