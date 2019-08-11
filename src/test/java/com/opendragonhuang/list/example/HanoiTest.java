package com.opendragonhuang.list.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class HanoiTest {

    @Test
    public void hanoi() {
        Hanoi.hanoi(3, 'x', 'y', 'z');
    }
}