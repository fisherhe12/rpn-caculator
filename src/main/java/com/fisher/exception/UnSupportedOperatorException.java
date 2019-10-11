package com.fisher.exception;

public class UnSupportedOperatorException extends RuntimeException {

	public UnSupportedOperatorException(String operator, int position) {
		super("Operator " + operator + "(position: " + position + "): not supported.");
	}
}
