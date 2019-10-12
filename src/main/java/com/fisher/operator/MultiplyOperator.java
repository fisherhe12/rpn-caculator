package com.fisher.operator;

import java.math.BigDecimal;

/**
 * @author Yu.He
 */
@Action(value = "*")
public class MultiplyOperator extends BinaryOperator {

    @Override
    protected BigDecimal doOperate(BigDecimal left, BigDecimal right) {
        return left.multiply(right);
    }
}

