package com.payment.exception;

public class InvalidCreditCardDetailsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5843831066236654154L;

	public InvalidCreditCardDetailsException(String msg) {
		super(msg);
	}

}
