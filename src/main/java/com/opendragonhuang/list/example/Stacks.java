package com.opendragonhuang.list.example;

import com.opendragonhuang.list.adt.MyList;
import com.opendragonhuang.list.adt.MyStack;
import com.opendragonhuang.list.implement.MyArrayList;
import com.opendragonhuang.list.implement.MyArrayStack;
import com.opendragonhuang.list.implement.MyLinkedList;
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

    /**
     * 括号匹配。
     * @param str
     * @return
     */
    public static boolean bracketsMatching(String str){
        MyStack<Character> stack = new MyArrayStack<>();
        char[] cbuf = str.toCharArray();
        for (char c : cbuf) {
            if(c != '(' && c != ')' && c != '[' && c != ']'){
                throw new IllegalArgumentException("传入的参数不合法！");
            }
        }

        for (char c : cbuf) {
            if(c == '(' || c == '['){
                stack.push(c);
            }

            if(c == ')'){
                if(stack.empty()){
                    return false;
                }else{
                    if(stack.getTop() == '('){
                        stack.pop();
                    }else{
                        return false;
                    }
                }
            }

            if(c == ']'){
                if(stack.empty()){
                    return false;
                }else{
                    if(stack.getTop() == '['){
                        stack.pop();
                    }else{
                        return false;
                    }
                }
            }
        }

        if(stack.empty()){
            return true;
        }else {
            return false;
        }

    }

    /**
     * 行编辑程序。
     * @param str
     * @return
     */
    public static String lineEdit(String str){
        MyStack<Character> stack = new MyArrayStack<>();
        char[] cbuf = str.toCharArray();

        for (char c : cbuf) {
            switch (c){
                case '#':
                    stack.pop();
                    break;
                case '@':
                    stack.clear();
                    break;
                default:
                    stack.push(c);
                    break;
            }
        }

        // 逆序堆栈的数据元素
        MyList<Character> list = new MyLinkedList<>();
        while (!stack.empty()){
            list.insert(1, stack.pop());
        }

        // list 转换成字符串
        StringBuilder sb = new StringBuilder();
        for (Character character : list) {
            sb.append(character);
        }

        list.clear();
        return sb.toString();
    }
}
