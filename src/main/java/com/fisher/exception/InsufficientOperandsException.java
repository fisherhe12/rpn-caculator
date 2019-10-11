package com.fisher.exception;

public class InsufficientOperandsException extends RuntimeException {

    public InsufficientOperandsException(String operator, int position) {
        super("Operator<>(position: <position>): insufficient operands");
    }
}
