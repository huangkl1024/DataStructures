package com.opendragonhuang.list.example;

import com.opendragonhuang.list.implement.MyLinkedStack;

/**
 * @author opendragonhuang
 * @version 1.0
 * @date 2019/8/8
 */
public class Stacks {
    /**
     * 十进制转换成二进制或八进制或十六进制程序。
     * @param numeralSystem 。
     * @param value 被转换的十进制值。
     * @return
     */
    public static String conversion(NumeralSystem numeralSystem, int value){
        MyLinkedStack<Integer> stack = new MyLinkedStack<>();
        int n = 0;
        StringBuilder sb = new StringBuilder();
        switch (numeralSystem){
            case BINARY:
                n = 2;
                sb.append("0B");
                break;
            case OCTAL:
                sb.append("0");
                n = 8;
                break;
            case HEX:
                sb.append("0X");
                n = 16;
                break;
            default:
                new IllegalArgumentException("不支持的进制转换");
                return null;
        }

        while (value != 0){
            stack.push(value%n);
            value /= n;
        }


        for(Integer i : stack){
            if(i < 10){
                sb.append(String.valueOf(i));
            }else{
                switch (i){
                    case 10:
                        sb.append('a');
                        break;
                    case 11:
                        sb.append('b');
                        break;
                    case 12:
                        sb.append('c');
                        break;
                    case 13:
                        sb.append('d');
                        break;
                    case 14:
                        sb.append('e');
                        break;
                    case 15:
                        sb.append('f');
                        break;
                }
            }
        }

        return sb.toString();
    }
}
