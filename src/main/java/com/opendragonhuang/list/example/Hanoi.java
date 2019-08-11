package com.opendragonhuang.list.example;

/**
 * 汉诺塔问题。
 * @author opendragonhuang
 * @version 1.0
 * @date 2019/8/11
 */
public class Hanoi {
    public static void hanoi(int n, char x, char y, char z){
        if(n == 1){
            move(z, 1, x);
        }else{
            hanoi(n-1, x, z, y);
            move(z, n, x);
            hanoi(n-1, y, x, z);
        }
    }

    private static void move(char dest, int n, char src){
        System.out.printf("将 %d 从 %c 移动到 %c\n", n, src, dest);
    }
}
