package com.opendragonhuang.list.adt;

/**
 * 堆栈的抽象数据类型定义。
 * @author opendragonhuang
 * @version 1.0
 * @date 2019/8/8
 */
public interface MyStack<T> extends Iterable<T>{
    /**
     * 获取堆栈当前存储的数据元素个数。
     * @return
     */
    int length();

    /**
     * 判断堆栈是否为空，为空返回 false，不为空返回 true。
     * @return
     */
    boolean empty();

    /**
     * 获取栈顶的数据元素，栈为空返回 null
     * @return
     */
    T getTop();

    /**
     * 出栈。
     * @return
     */
    T pop();

    /**
     * 入栈。
     * @param e
     */
    void push(T e);

    /**
     * 从栈顶到栈底依次遍历栈存储的数据元素。
     */
    void traverse();

    /**
     * 清空栈。
     */
    void clear();
}

