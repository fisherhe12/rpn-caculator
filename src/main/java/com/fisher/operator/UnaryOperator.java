package com.fisher.operator;

import com.fisher.common.StackUtils;
import com.fisher.exception.InsufficientOperandsException;
import java.math.BigDecimal;
import java.util.Stack;

/**
 * Base unary operator class, it's the same as BinaryOperator
 *
 * @author Yu.He
 */
public abstract class UnaryOperator implements Operator {

    @Override
    public void operate(Stack<BigDecimal> operandStack, Stack<BigDecimal> bufferStack,
        int position) {
        Action operatorAction = this.getClass().getAnnotation(Action.class);

        if (operandStack.isEmpty()) {
            throw new InsufficientOperandsException(operatorAction.value(), position);
        }
        //store the previous operands into bufferStack
        StackUtils.copy(operandStack, bufferStack);

        BigDecimal result = doOperation(operandStack.pop());
        operandStack.push(result);
    }

    protected abstract BigDecimal doOperation(BigDecimal value);
}
