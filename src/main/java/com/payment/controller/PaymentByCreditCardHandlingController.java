package com.payment.controller;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.payment.dto.TransactionResponse;
import com.payment.entity.TransactionByCreditCard;
import com.payment.services.ICreditCardTransactionServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("payment-by-credit-card-handling-controller")
@CrossOrigin("*")
@Api(value = "This controller handles payment done by credit card")
public class PaymentByCreditCardHandlingController {

	@Autowired
	private ICreditCardTransactionServices creditCardServices;

	@PostMapping("make-payment-by-cedit-card")
	@ApiOperation("Please do not pass serialIdTransactionByCreditCard in request")
	public ResponseEntity<TransactionResponse> makePaymentByCreditCard(
			@RequestBody TransactionByCreditCard transactionByCreditCard) {
		TransactionResponse transactionResponse = new TransactionResponse(503, LocalDateTime.now(),
				transactionByCreditCard.getTransactionIdForPaymentByCreditCard(),
				transactionByCreditCard.getNameOnCreditCard(), true, false, "Transaction failed");
		try {
			if (creditCardServices.processTransaction(transactionByCreditCard)) {
				transactionResponse = new TransactionResponse(200, LocalDateTime.now(),
						transactionByCreditCard.getTransactionIdForPaymentByCreditCard(),
						transactionByCreditCard.getNameOnCreditCard(), false, true, "Transaction Successfull");
				return ResponseEntity.status(HttpStatus.OK).body(transactionResponse);
			}
		} catch (Exception e) {
			transactionResponse = new TransactionResponse(503, LocalDateTime.now(),
					transactionByCreditCard.getTransactionIdForPaymentByCreditCard(),
					transactionByCreditCard.getNameOnCreditCard(), true, false, e.getLocalizedMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(transactionResponse);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(transactionResponse);
	}

}
