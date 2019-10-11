package com.fisher.operator;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * com.fisher.rpncaculator.operator
 *
 * @author Yu.He
 */
public class AddOperator implements Operator {

    @Override
    public String getExpression() {
        return "+";
    }

    @Override
    public void calculate(Stack<BigDecimal> operandStack) {

    }
}
