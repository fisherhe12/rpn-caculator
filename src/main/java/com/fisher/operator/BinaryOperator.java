package com.fisher.operator;

import com.fisher.exception.InsufficientOperandsException;

import java.math.BigDecimal;
import java.util.Stack;

import static com.fisher.common.OperatorConstants.BINARY;

public abstract class BinaryOperator implements Operator {

	public void operate(Stack<BigDecimal> operandStack, int position) {
		Action operatorAction = this.getClass().getAnnotation(Action.class);

		if (operandStack.isEmpty() || operandStack.size() < BINARY) {
			throw new InsufficientOperandsException(operatorAction.value(), position);
		}

		BigDecimal right = operandStack.pop();
		BigDecimal left = operandStack.pop();

		BigDecimal result = doOperation(left, right);
		operandStack.push(result);
	}

	protected abstract BigDecimal doOperation(BigDecimal left, BigDecimal right);
}
