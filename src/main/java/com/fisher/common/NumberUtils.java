package com.fisher.common;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * com.fisher.common
 *
 * @author Yu.He
 */
public class NumberUtils {

	public static boolean isNumberic(String input) {
		return input.matches("-?\\d+(\\.\\d+)?");
	}

	public static BigDecimal parse(String input) {
		return new BigDecimal(input).setScale(15, RoundingMode.HALF_UP);
	}
}
