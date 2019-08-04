package com.opendragonhuang.list.implement;

import com.opendragonhuang.list.adt.MyList;
import com.opendragonhuang.list.exception.MyListIsEmptyException;

import java.util.Iterator;

/**
 * @author opendragonhuang
 * @version 1.0
 * @date 2019/8/4
 */
public class MyStaticSingleLinkedList<T extends Comparable<T>> implements MyList<T>, Iterable<T> {

    private ListNode<T>[] memory;
    private final int MEMORY_SIZE = 1000;
    private int freeMemory = MEMORY_SIZE;
    private int length;
    private int head;


    public MyStaticSingleLinkedList() {
        initMemory();
        // 初始化头节点
        head = malloc();
        memory[head].cur = 0;
    }

    private void initMemory(){
        memory = new ListNode[MEMORY_SIZE];
        for (int i = 0; i < MEMORY_SIZE; i++) {
            memory[i] = new ListNode();
            if(i == MEMORY_SIZE -1){
                memory[i].cur = -1;
            }else {
                memory[i].cur = i+1;
            }
        }
    }

    private int malloc(){
        if(memory[0].cur == -1){
            return -1;
        }else{
            int i = memory[0].cur;
            memory[0].cur = memory[i].cur;
            freeMemory--;
            return i;
        }

    }

    private void free(int i){
        memory[i].cur = memory[0].cur;
        memory[0].cur = i;
        freeMemory++;
    }

    public int getFreeMemory() {
        return freeMemory;
    }

    /**
     * 清空线性表。
     */
    @Override
    public void clear() {
        int p = memory[head].cur;
        int q;
        while (p != 0){
            q = p;
            p = memory[p].cur;
            free(q);
        }
        memory[head].cur = 0;

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

        return memory[_getElem(i)].value;
    }

    /**
     * 返回线性表第一个与数据元素 e 相等的数据元素的位置。
     *
     * @param e
     * @return
     */
    @Override
    public int locateElem(T e) {
        int p = memory[head].cur;
        int i = 1;
        while (p != 0){
            if(memory[p].value.compareTo(e) == 0){
                return i;
            }
            i++;
            p = memory[p].cur;
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
        int p = head;
        while (memory[p].cur != 0){
            if(memory[memory[p].cur].value.compareTo(curElem) == 0){
                return memory[p].value;
            }
            p = memory[p].cur;
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
        int p = memory[head].cur;
        while (p != 0){
            if(memory[p].value.compareTo(curElem) == 0){
                if(memory[p].cur == 0){
                    return null;
                }else{
                    return memory[memory[p].cur].value;
                }
            }
            p = memory[p].cur;
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

        int p = _getElem(i-1);
        int node = malloc();
        memory[node].value = e;
        memory[node].cur = memory[p].cur;
        memory[p].cur = node;
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

        int p = _getElem(i-1);
        int q = memory[p].cur;
        T e = memory[q].value;
        memory[p].cur = memory[q].cur;
        free(q);
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
        MyList<T> myList = null;
        try {
            myList = (MyList<T>) super.clone();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return myList;
    }

    private int _getElem(int i){
        int p = head;
        int j = 0;
        while(p != 0 && j < i){
            p = memory[p].cur;
            j++;
        }

        return p;
    }


    @Override
    public Iterator<T> iterator() {
        return new MyStaticSingleLinkedListIterator();
    }

    private class MyStaticSingleLinkedListIterator implements Iterator<T>{
        int p = memory[head].cur;

        @Override
        public boolean hasNext() {
            return p != 0;
        }


        @Override
        public T next() {
            T e = (T)memory[p].value;
            p = memory[p].cur;
            return e;
        }

        @Override
        public void remove() {

        }
    }
}

class ListNode<T>{
    T value;
    int cur;

    public ListNode() {
    }

    public ListNode(T value, int cur) {
        this.value = value;
        this.cur = cur;
    }
}
