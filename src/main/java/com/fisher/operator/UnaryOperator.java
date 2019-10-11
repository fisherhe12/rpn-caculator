package com.fisher.operator;

import com.fisher.exception.InsufficientOperandsException;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * com.fisher.operator
 *
 * @author fisher
 * @date 2019-10-12
 */
public abstract class UnaryOperator implements Operator {

	public void operate(Stack<BigDecimal> operandStack, int position) {
		Action operatorAction = this.getClass().getAnnotation(Action.class);

		if (operandStack.isEmpty()) {
			throw new InsufficientOperandsException(operatorAction.value(), position);
		}

		BigDecimal result = doOperation(operandStack.pop());
		operandStack.push(result);
	}

	protected abstract BigDecimal doOperation(BigDecimal value);
}
