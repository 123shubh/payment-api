package com.payment.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.Month;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import com.payment.dto.TransactionResponse;
import com.payment.entity.CreditCard;
import com.payment.entity.TransactionByCreditCard;
import com.payment.repository.CreditCardRepository;
import com.payment.repository.TransactionRepositoryForCreditCard;

@SpringBootTest
class PaymentByCreditCardHandlingControllerTest {

	@Autowired
	PaymentByCreditCardHandlingController paymentByCreditCardHandlingController;

	@MockBean
	CreditCardRepository creditCardRepository;

	@MockBean
	TransactionRepositoryForCreditCard transactionRepositoryForCreditCard;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	private static CreditCard creditCard;
	private static TransactionByCreditCard newTransactionByCreditCard;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		LocalDate expiryDate = LocalDate.of(2028, Month.MAY, 5);
		creditCard = new CreditCard("11223344556677", "shubham", expiryDate, "123", "123456789012345", "VISA", 100000D,
				10000D, 90000D);
		newTransactionByCreditCard = new TransactionByCreditCard(1002, "1002", "Credit Card", 10000, "BookingCom",
				"shubham", "11223344556677", expiryDate, "123");
	}

	@Test
	void testMakePaymentByCreditCard() {
		when(transactionRepositoryForCreditCard.findByTransactionIdForPaymentByCreditCard("1001")).thenReturn(null);
		when(creditCardRepository.findByCreditCardNumber("11223344556677")).thenReturn(creditCard);
		ResponseEntity<TransactionResponse> transactionResponse = paymentByCreditCardHandlingController
				.makePaymentByCreditCard(newTransactionByCreditCard);
		assertEquals(200, transactionResponse.getBody().getResponseCode());

	}

}
