package com.payment.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.payment.entity.CreditCard;
import com.payment.entity.TransactionByCreditCard;
import com.payment.exception.InvalidCreditCardDetailsException;
import com.payment.exception.LowBalanceException;
import com.payment.repository.CreditCardRepository;
import com.payment.repository.TransactionRepositoryForCreditCard;

@SpringBootTest
class CreditCardTransactionServicesImplTest {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@MockBean
	private TransactionRepositoryForCreditCard transactionRepositoryForCreditCard;

	@MockBean
	private CreditCardRepository creditCardRepository;

	@Autowired
	private ICreditCardTransactionServices creditCardTransactionServices;

	private static CreditCard creditCard;
	private static Optional<TransactionByCreditCard> transactionByCreditCard;
	private static Optional<TransactionByCreditCard> newTransactionByCreditCard;

	@BeforeAll
	public static void setUpForCreditCardAndTransactionRepositoryForCreditCard() {
		LocalDate expiryDate = LocalDate.of(2028, Month.MAY, 5);
		creditCard = new CreditCard("11223344556677", "shubham", expiryDate, "123", "123456789012345", "VISA", 100000D,
				10000D, 90000D);
		transactionByCreditCard = Optional.of(new TransactionByCreditCard(1001, "1001", "Credit Card", 10000,
				"BookingCom", "shubham", "11223344556677", expiryDate, "123"));
		newTransactionByCreditCard = Optional.of(new TransactionByCreditCard(1002, "1002", "Credit Card", 10000,
				"BookingCom", "shubham", "11223344556677", expiryDate, "123"));
	}

	@Test
	void testProcessTransaction() throws InvalidCreditCardDetailsException, LowBalanceException {
		when(creditCardRepository.findByCreditCardNumber("11223344556677")).thenReturn(creditCard);
		assertEquals(true, creditCardTransactionServices.processTransaction(newTransactionByCreditCard.get()));
	}

	@Test
	void testVerifyCreditCardDetails() throws InvalidCreditCardDetailsException {
		when(transactionRepositoryForCreditCard.findByTransactionIdForPaymentByCreditCard("1001"))
				.thenReturn(transactionByCreditCard);
		when(creditCardRepository.findByCreditCardNumber("11223344556677")).thenReturn(creditCard);
		assertEquals(true, creditCardTransactionServices.verifyCreditCardDetails(newTransactionByCreditCard.get()));
	}

}
