package com.payment.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.payment.entity.CreditCard;
import com.payment.repository.CreditCardRepository;

@SpringBootTest
class CreditCardServiceImplTest {

	@MockBean
	private CreditCardRepository creditCardRepository;

	@Autowired
	private ICreditCardServices creditCardServices;

	private static CreditCard creditCard;

	@BeforeAll
	public static void set() {

		LocalDate expiryDate = LocalDate.of(2028, Month.MAY, 5);
		creditCard = new CreditCard("11223344556677", "shubham", expiryDate, "123", "123456789012345", "VISA", 100000D,
				10000D, 90000D);

	}

	@Test
	void addCreditCard() throws Exception {
		when(creditCardRepository.findByCreditCardNumber(creditCard.getCreditCardNumber())).thenReturn(null);
		when(creditCardRepository.save(creditCard)).thenReturn(creditCard);
		assertEquals(true, creditCardServices.addCreditCard(creditCard));
	}

}
