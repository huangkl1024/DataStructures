package com.opendragonhuang.list.implement;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyArrayStackTest {
    @Test
    public void test(){
        MyArrayStack<Integer> stack = new MyArrayStack<>();
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