package com.fpt.topgun.exception;

public class OrderException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public OrderException(String exception) {
    super(exception);
  }
}
