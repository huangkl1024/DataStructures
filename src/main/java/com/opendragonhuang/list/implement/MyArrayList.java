package com.opendragonhuang.list.implement;

import com.opendragonhuang.list.adt.MyList;
import com.opendragonhuang.list.exception.MyListIsEmptyException;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author opendragonhuang
 * @version 1.0
 * @date 2019/8/3
 */
public class MyArrayList<T extends Comparable<T>> implements MyList<T>, Iterable<T>{
    private T[] value;
    private int length;
    private final int DEFAULT_CAPACITY = 10;


    public MyArrayList() {
        value = (T[])(new Comparable[DEFAULT_CAPACITY]);
    }

    public MyArrayList(int capacity){
        value = (T[])(new Comparable[capacity]);
    }

    /**
     * 清空线性表。
     */
    @Override
    public void clear() {
        value = (T[])(new Comparable[DEFAULT_CAPACITY]);
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

        return value[i-1];
    }

    /**
     * 返回线性表第一个与数据元素 e 相等的数据元素的位置。
     *
     * @param e
     * @return
     */
    @Override
    public int locateElem(T e) {
        for (int i = 0; i < length; i++) {
            if(value[i].compareTo(e) == 0){
                return i+1;
            }
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
    public T priorElem(T curElem) {
        for (int i = 0; i < length; i++) {
            if(value[i].compareTo(curElem) == 0){
                if(i > 0){
                    return value[i-1];
                }else{
                    return null;
                }

            }
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
        for (int i = 0; i < length; i++) {
            if(value[i].compareTo(curElem) == 0){
                if(i == length-1){
                    return null;
                }else{
                    return value[i+1];
                }

            }
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

        if(length == value.length){
            grow();
        }

        // 往 i - 1 位置插入数据元素
        for (int j = length-1; j >= i-1 ; j--) {
            value[j+1] = value[j];
        }
        value[i-1] = e;

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
            throw new MyListIsEmptyException("线性表为空，无法删除");
        }

        if(i < 1 || i > length){
            throw new IndexOutOfBoundsException("传入的索引超出了线性表的长度");
        }

        T tmp = value[i-1];

        for (int j = i-1; j < length-1; j++) {
            value[j] = value[j+1];
        }

        length--;

        if(length <= value.length/2){
            reduce();
        }

        return tmp;
    }

    @Override
    public void traverse() {
        for(T e : this){
            System.out.print(e+"\t");
        }
        System.out.println();
    }

    private void grow(){
        T[] oldValue = value;
        value = Arrays.copyOf(oldValue, oldValue.length/2 + oldValue.length);
    }

    private void reduce(){
        T[] oldValue = value;
        value = Arrays.copyOf(oldValue, oldValue.length/2);
    }

    @Override
    public Iterator<T> iterator() {
        return new MyArrayListIterator();
    }

    private class MyArrayListIterator implements Iterator<T>{
        int cur_position = 0;

        @Override
        public boolean hasNext() {
            return cur_position < length;
        }

        @Override
        public T next() {
            T e = value[cur_position++];
            return e;
        }

        @Override
        public void remove() {
            delete(cur_position-1);
        }

    }

    @Override
    public MyArrayList<T> clone(){
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return (MyArrayList<T>) obj;
    }
}
