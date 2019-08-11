package com.opendragonhuang.list.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class EvaluateExpressionTest {

    @Test
    public void evaluate() {
        String expr = "#3*(7-2)#";
        System.out.println(expr.substring(1, expr.length()-1)+"="+EvaluateExpression.evaluate(expr));
    }
}