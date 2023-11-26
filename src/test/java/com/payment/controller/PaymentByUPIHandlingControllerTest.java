package com.payment.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import com.payment.dto.TransactionResponse;
import com.payment.entity.TransactionByUpi;
import com.payment.entity.UPI;
import com.payment.repository.TransactionRepositoryForUpi;
import com.payment.repository.UPIRepository;

@SpringBootTest
class PaymentByUPIHandlingControllerTest {

	@MockBean
	UPIRepository upiRepository;

	@MockBean
	TransactionRepositoryForUpi transactionRepositoryForUpi;

	@Autowired
	PaymentByUPIHandlingController paymentByUPIHandlingController;

	static Optional<UPI> upi;
	static Optional<TransactionByUpi> transactionByUpi;
	static TransactionByUpi newTransactionByUpi;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		upi = Optional.of(new UPI("sd@okhdfc", "123456789009876", "hdfc", 100000, "123456", "sd"));
		transactionByUpi = Optional
				.of(new TransactionByUpi(1000, "1000", "upi", 5000, "bookingcom", "sd@okhdfc", "123456", "sd"));
		newTransactionByUpi = new TransactionByUpi(1001, "1001", "upi", 5000, "bookingcom", "sd@okhdfc", "123456",
				"sd");
	}

	@Test
	void testMakePaymentByUpi() {
		when(upiRepository.findByUpiId(newTransactionByUpi.getUpiId())).thenReturn(upi.get());
		ResponseEntity<TransactionResponse> transactionResponse = paymentByUPIHandlingController
				.makePaymentByUpi(newTransactionByUpi);
		assertEquals(200, transactionResponse.getBody().getResponseCode());
	}

}
