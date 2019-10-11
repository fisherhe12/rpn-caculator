package com.fisher.operator;

import java.math.BigDecimal;
import java.util.Stack;

@Action(value = "undo")
public class UndoOperator implements Operator {

	public void operate(Stack<BigDecimal> operandStack, int position) {
	}

	private void copyStack(Stack<BigDecimal> from, Stack<BigDecimal> to) {
		while (!from.isEmpty()) {
			to.push(from.pop());
		}
	}

}
