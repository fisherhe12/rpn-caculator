package com.fisher.operator;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * @author Yu.He
 */
public interface Operator {

    /**
     * Core execution method, handle each operator by stack
     */
    void operate(Stack<BigDecimal> operandStack, Stack<BigDecimal> bufferStack, int position);
}
