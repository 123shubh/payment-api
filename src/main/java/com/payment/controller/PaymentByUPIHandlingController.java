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
import com.payment.entity.TransactionByUpi;
import com.payment.services.IUPITransactionServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/payment-by-upi-handling-controller")
@CrossOrigin("*")
@Api(value = "This controller handles payment done by UPI")
public class PaymentByUPIHandlingController {

	@Autowired
	private IUPITransactionServices iupiServices;

	@PostMapping("make-payment-by-upi")
	@ApiOperation("Please do not pass serialIdTransactionByUpi in request")
	public ResponseEntity<TransactionResponse> makePaymentByUpi(@RequestBody TransactionByUpi transactionByUpi) {
		TransactionResponse transactionResponse = new TransactionResponse(503, LocalDateTime.now(),
				transactionByUpi.getTransactionIdForPaymentByUpi(), transactionByUpi.getUpiHolderName(), true, false,
				"Transaction failed");
		try {
			if (iupiServices.processUPITransaction(transactionByUpi)) {
				transactionResponse = new TransactionResponse(200, LocalDateTime.now(),
						transactionByUpi.getTransactionIdForPaymentByUpi(), transactionByUpi.getUpiHolderName(), false,
						true, "Transaction Successfull");
				return ResponseEntity.status(HttpStatus.OK).body(transactionResponse);
			}
		} catch (Exception e) {
			transactionResponse = new TransactionResponse(503, LocalDateTime.now(),
					transactionByUpi.getTransactionIdForPaymentByUpi(), transactionByUpi.getUpiHolderName(), true,
					false, e.getLocalizedMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(transactionResponse);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(transactionResponse);
	}

}
