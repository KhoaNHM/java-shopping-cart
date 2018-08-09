package com.fpt.topgun.exception;

public class OrderDetailException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public OrderDetailException(String exception) {
    super(exception);
  }
}
