package com.fisher.operator;

import java.math.BigDecimal;

/**
 * com.fisher.rpncaculator.operator
 *
 * @author Yu.He
 */
@Action(value = "-")
public class SubtractOperator extends BinaryOperator {
	@Override
	protected BigDecimal doOperation(BigDecimal left, BigDecimal right) {
		return left.subtract(right);
	}
}

