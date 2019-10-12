package com.fisher.common;

import static com.fisher.common.OperatorConstants.DEFAULT_PRECISION;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * com.fisher.common
 *
 * @author Yu.He
 */
public class NumberUtils {

    public static boolean isNumeric(String input) {
        return input.matches("-?\\d+(\\.\\d+)?");
    }

    public static BigDecimal parse(String input) {
        return new BigDecimal(input).setScale(DEFAULT_PRECISION, RoundingMode.HALF_UP);
    }

    public static BigDecimal parse(double input) {
        return BigDecimal.valueOf(input).setScale(DEFAULT_PRECISION, RoundingMode.HALF_UP);
    }
}
