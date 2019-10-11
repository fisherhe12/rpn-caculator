package com.fisher.exception;

public class EmptyExpressionException extends RuntimeException {

	public EmptyExpressionException() {
		super("Nothing to evaluate here.");
	}

}
