package com.fisher.operator;

import java.math.BigDecimal;

@Action(value = "abs")
public class AbsOperator extends UnaryOperator {

    @Override
    protected BigDecimal doOperation(BigDecimal value) {
        return value.abs();
    }
}
