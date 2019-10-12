package com.fisher.exception;

public class InsufficientOperandsException extends RuntimeException {

    public InsufficientOperandsException(String operator, int position) {
        super("Operator " + operator + "(position: " + position + "): insufficient operands");
    }
}
