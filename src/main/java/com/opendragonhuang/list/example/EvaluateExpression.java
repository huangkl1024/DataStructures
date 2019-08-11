package com.opendragonhuang.list.example;

import com.opendragonhuang.list.adt.MyStack;
import com.opendragonhuang.list.implement.MyLinkedStack;

/**
 * 求表达式的值，只能解析加减乘除和个位整数。
 * @author opendragonhuang
 * @version 1.0
 * @date 2019/8/11
 */
public class EvaluateExpression {
    // + - * / ( ) # : 0-6
    // x1 > x2 : 1, x1 = x2 ：0, x1 < x2：-1, error : -2
    private static byte[][] priority = {
            {1, 1, -1, -1, -1, 1, 1},
            {1, 1, -1, -1, -1, 1, 1},
            {1, 1, 1, 1, -1, 1, 1},
            {1, 1, 1, 1, -1, 1, 1},
            {-1, -1, -1, -1, -1, 0, -2},
            {1, 1, 1, 1, -2, 1, 1},
            {-1, -1, -1, -1, -1, -2, 0}
    };

    /**
     * 获取运算符对应的编码。
     * @param ch
     * @return
     */
    private static byte getOperatorCode(char ch){
        byte ret = -1;

        switch (ch){
            case '+':
                ret = 0;
                break;
            case '-':
                ret = 1;
                break;
            case '*':
                ret = 2;
                break;
            case '/':
                ret = 3;
                break;
            case '(':
                ret = 4;
                break;
            case ')':
                ret = 5;
                break;
            case '#':
                ret = 6;
                break;
        }

        return ret;
    }

    /**
     * 获取两个运算符的相对优先级。
     * @param x1
     * @param x2
     * @return
     */
    private static byte getPriority(byte x1, byte x2){
        return priority[x1][x2];
    }

    /**
     * 计算 a ch b 的结果。
     * @param a
     * @param b
     * @param ch
     * @return
     */
    private static int cal(int a, int b, char ch){
        int result = 0;

        switch (ch){
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                result = a / b;
                break;
        }

        return result;
    }

    /**
     * 判断是否为操作数。
     * @param ch
     * @return
     */
    private static boolean isOperand(char ch){
        if(ch < 48 || ch > 57){
            return false;
        }
        return true;
    }

    /**
     * 解析表达式。
     * @param expression
     * @return
     */
    public static int evaluate(String expression){
        MyStack<Character> operator = new MyLinkedStack<>();
        MyStack<Integer> operand = new MyLinkedStack<>();
        char[] expr = expression.toCharArray();

        // 把 # 入栈
        operator.push(expr[0]);
        int a = 0;
        int b = 0;
        char ch = 0;
        int i = 1;
        while (i < expr.length) {
            if(isOperand(expr[i])){
                operand.push(Integer.valueOf(expr[i])-48);
                i++;
            }else{
                switch (getPriority(getOperatorCode(operator.getTop()), getOperatorCode(expr[i]))){
                    case -1:
                        operator.push(expr[i]);
                        i++;
                        break;
                    case 0:
                        operator.pop();
                        i++;
                        break;
                    case 1:
                        b = operand.pop();
                        a = operand.pop();
                        ch = operator.pop();
                        operand.push(cal(a, b, ch));
                        break;
                }
            }
        }

        return operand.getTop();
    }

}
