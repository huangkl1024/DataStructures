package com.opendragonhuang.list.implement;

import com.opendragonhuang.list.adt.MyStack;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 堆栈的顺序实现。
 * @author opendragonhuang
 * @version 1.0
 * @date 2019/8/8
 */
public class MyArrayStack<T> implements MyStack<T> {
    private T value[];
    private final int DEFAULT_CAPACITY = 10;
    private int length;
    private int top = -1;

    public MyArrayStack() {
        value = (T[])(new Object[DEFAULT_CAPACITY]);
    }

    public MyArrayStack(int capacity){
        value = (T[])(new Object[capacity]);
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
            return value[top];
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
            T e = value[top--];
            length--;
            reduce();
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
        grow();
        value[++top] = e;
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
        for (int i = 0; i < length; i++) {
            value[i] = null;
        }
        top = -1;
        length = 0;
        reduce();
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new MyArrayStackIterator();
    }

    private class MyArrayStackIterator implements Iterator<T>{
        private int index = length-1;

        @Override
        public boolean hasNext() {
            return index > 0;
        }

        @Override
        public T next() {
            T e = value[index--];
            return e;
        }
    }

    private void grow(){
        // 空间不够，需要扩容。
        if(length == value.length){
            T[] oldValue = value;
            value = Arrays.copyOf(oldValue, oldValue.length/2+oldValue.length);
        }
    }

    private void reduce(){
        // 大量空间没有使用，减少占用的存储空间
        if(length <= value.length/2){
            T[] oldValue = value;
            value = Arrays.copyOf(oldValue, oldValue.length/2);
        }
    }
}