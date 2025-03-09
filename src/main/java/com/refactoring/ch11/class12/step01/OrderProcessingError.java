package com.refactoring.ch11.class12.step01;

public class OrderProcessingError extends RuntimeException {
	private final int code;

	public OrderProcessingError(int code) {
		super("주문 처리 오류 code=" + code);
		this.code = code;
	}

	public String name() {
		return "OrderProcessingError";
	}

	public int getCode() {
		return code;
	}
}
