package com.opendragonhuang.list.implement;

import com.opendragonhuang.list.adt.MyStack;

import java.util.Iterator;

/**
 * 堆栈的链式存储实现，链表头为栈底。
 * @author opendragonhuang
 * @version 1.0
 * @date 2019/8/8
 */
public class MyLinkedStack<T> implements MyStack<T> {
    private class Node{
        T value;
        Node next;

        public Node() {
        }

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node head;
    private int length = 0;

    public MyLinkedStack() {
        head = new Node();
        head.next = null;
    }

    /**
     * 获取堆栈当前存储的数据元素个数。
     *
     * @return
     */
    @Override
    public int length() {
        return length;
    }

    /**
     * 判断堆栈是否为空，为空返回 false，不为空返回 true。
     *
     * @return
     */
    @Override
    public boolean empty() {
        return length == 0;
    }

    /**
     * 获取栈顶的数据元素，栈为空返回 null
     *
     * @return
     */
    @Override
    public T getTop() {
        if(empty()){
            return null;
        }else{
            return head.next.value;
        }
    }

    /**
     * 出栈。
     *
     * @return
     */
    @Override
    public T pop() {
        if(empty()){
            return null;
        }else{
            T e = head.next.value;
            head.next = head.next.next;
            length--;
            return e;
        }
    }

    /**
     * 入栈。
     *
     * @param e
     */
    @Override
    public void push(T e) {
        Node node = new Node();
        node.value = e;

        node.next = head.next;
        head.next = node;
        length++;
    }

    /**
     * 从栈底到栈顶依次遍历栈存储的数据元素。
     */
    @Override
    public void traverse() {
        for(T e : this){
            System.out.print(e+"\t");
        }
        System.out.println();
    }

    /**
     * 清空栈。
     */
    @Override
    public void clear() {
        head.next = null;
        length = 0;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new MyLinkedStackIterator();
    }

    private class MyLinkedStackIterator implements Iterator<T>{
        Node p = head.next;

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
    }
}
