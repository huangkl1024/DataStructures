package com.opendragonhuang.list.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class StacksTest {

    @Test
    public void conversion() {
        System.out.println(Stacks.conversion(NumeralSystem.BINARY, 15));
        System.out.println(Stacks.conversion(NumeralSystem.HEX, 10));
        System.out.println(Stacks.conversion(NumeralSystem.OCTAL, 12));
    }

    @Test
    public void bracketsMatching() {
        System.out.println(Stacks.bracketsMatching("([()])"));
        System.out.println(Stacks.bracketsMatching("()(]])"));
    }

    @Test
    public void lineEdit() {
        System.out.println(Stacks.lineEdit("whli##ilr#e(s#*s)\n"));
        System.out.println(Stacks.lineEdit("outcha@putchar(*s=#++)\n"));
    }
}