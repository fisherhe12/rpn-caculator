package com.fisher.exception;

public class UnSupportedOperatorException extends RuntimeException {

    public UnSupportedOperatorException(String operator) {
        super("Operator '" + operator + "' is not implemented in the calculator.");
    }
}
