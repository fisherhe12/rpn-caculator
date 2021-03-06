package com.fisher.operator;

import com.fisher.common.StackUtils;
import java.math.BigDecimal;
import java.util.Stack;

/**
 * @author Yu.He
 */
@Action(value = "undo")
public class UndoOperator implements Operator {

    @Override
    public void operate(Stack<BigDecimal> operandStack, Stack<BigDecimal> bufferStack,
        int position) {

        //Restore the previous operand stack by bufferStack
        if (!operandStack.isEmpty()) {
            bufferStack.pop();
            StackUtils.copy(bufferStack, operandStack);
        }
    }
}
