package com.fisher.operator;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * @author Yu.He
 */
@Action("clear")
public class ClearOperator implements Operator {

    @Override
    public void operate(Stack<BigDecimal> operandStack, Stack<BigDecimal> bufferStack,
        int position) {

        if (!operandStack.isEmpty()) {
            operandStack.clear();
        }
        if (!bufferStack.isEmpty()) {
            bufferStack.clear();
        }
    }
}
