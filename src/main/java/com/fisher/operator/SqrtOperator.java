package com.fisher.operator;

import com.fisher.common.NumberUtils;
import java.math.BigDecimal;

/**
 * @author Yu.He
 */
@Action(value = "sqrt")
public class SqrtOperator extends UnaryOperator {

    @Override
    protected BigDecimal doOperation(BigDecimal value) {
        double doubleValue = value.doubleValue();
        return NumberUtils.parse(Math.sqrt(doubleValue));
    }
}
