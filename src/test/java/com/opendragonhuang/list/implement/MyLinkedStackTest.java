package com.opendragonhuang.list.implement;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyLinkedStackTest {
    @Test
    public void test(){
        MyLinkedStack<Integer> stack = new MyLinkedStack<>();
        for (int i = 0; i < 20; i++) {
            stack.push(i);
        }
        stack.traverse();
        for (int i = 0; i < 20; i++) {
            System.out.print(stack.pop()+"\t");
        }
        System.out.println();
    }
}