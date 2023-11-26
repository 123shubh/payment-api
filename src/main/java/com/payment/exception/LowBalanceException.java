package com.payment.exception;

public class LowBalanceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6658354372533474357L;

	public LowBalanceException(String msg) {
		super(msg);
	}

}
