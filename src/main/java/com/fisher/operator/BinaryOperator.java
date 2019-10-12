package com.fisher.operator;

import static com.fisher.common.OperatorConstants.BINARY;

import com.fisher.common.StackUtils;
import com.fisher.exception.InsufficientOperandsException;
import java.math.BigDecimal;
import java.util.Stack;

/**
 * Base Binary operator class,using template method mode to extract the common logic processing
 *
 * @author Yu.He
 */
public abstract class BinaryOperator implements Operator {

    @Override
    public void operate(Stack<BigDecimal> operandStack, Stack<BigDecimal> bufferStack,
        int position) {
        Action operatorAction = this.getClass().getAnnotation(Action.class);

        if (operandStack.isEmpty() || operandStack.size() < BINARY) {
            throw new InsufficientOperandsException(operatorAction.value(), position);
        }
        //store the previous operands into bufferStack
        StackUtils.copy(operandStack, bufferStack);

        BigDecimal right = operandStack.pop();
        BigDecimal left = operandStack.pop();
        BigDecimal result = doOperate(left, right);

        operandStack.push(result);
    }

    protected abstract BigDecimal doOperate(BigDecimal left, BigDecimal right);

}
