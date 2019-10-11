package com.fisher.common;

/**
 * com.fisher.common
 *
 * @author Yu.He
 */
public class NumberUtils {

    public static boolean isNumberic(String input) {
        return input.matches("-?\\d+(\\.\\d+)?");
    }
}
