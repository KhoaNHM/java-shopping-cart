package com.fpt.topgun.exception;

public class ProductException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ProductException(String exception) {
		super(exception);
	}
}