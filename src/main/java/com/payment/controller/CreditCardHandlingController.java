package com.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.entity.CreditCard;
import com.payment.services.ICreditCardServices;

@RestController
@RequestMapping("/credit-card-handling-controller")
public class CreditCardHandlingController {

	@Autowired
	private ICreditCardServices creditCardServices;

	@PostMapping("save-credit-card")
	public ResponseEntity<String> saveCreditCard(@RequestBody CreditCard creditCard) {
		try {
			creditCardServices.addCreditCard(creditCard);
			return ResponseEntity.status(HttpStatus.OK).body("Credit card added successfully");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getLocalizedMessage());
		}
	}
}
