package com.fisher.operator;

import java.math.BigDecimal;
import java.util.Stack;


public interface Operator {

    String getExpression();

    void calculate(Stack<BigDecimal> operandStack);
}
