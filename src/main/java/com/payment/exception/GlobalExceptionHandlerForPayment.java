package com.payment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandlerForPayment {

	@ResponseBody
	@ExceptionHandler(InvalidCreditCardDetailsException.class)
	public ResponseEntity<String> invalidCreditCardDetailsException(
			InvalidCreditCardDetailsException invalidCreditCardDetailsException) {
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
				.body(invalidCreditCardDetailsException.getLocalizedMessage());
	}

	@ResponseBody
	@ExceptionHandler(LowBalanceException.class)
	public ResponseEntity<String> lowBalanceException(LowBalanceException lowBalanceException) {
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(lowBalanceException.getLocalizedMessage());
	}

	@ResponseBody
	@ExceptionHandler(InvalidUPIDetailsException.class)
	public ResponseEntity<String> invalidUPIDetailsException(InvalidUPIDetailsException invalidUPIDetailsException) {
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(invalidUPIDetailsException.getLocalizedMessage());
	}

}
