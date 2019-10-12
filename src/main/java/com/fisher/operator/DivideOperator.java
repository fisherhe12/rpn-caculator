package com.fisher.operator;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Action(value = "/")
public class DivideOperator extends BinaryOperator {

    @Override
    protected BigDecimal doOperate(BigDecimal left, BigDecimal right) {
        return left.divide(right, RoundingMode.HALF_UP);
    }
}

