package com.payment.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.payment.entity.UPI;
import com.payment.repository.UPIRepository;

@SpringBootTest
class UpiServicesImplTest {

	@MockBean
	private UPIRepository upiRepository;
	
	@Autowired
	IUpiServices upiServices;
	
	UPI upi;
	
	@BeforeEach
	void setUp() throws Exception {
		upi = new UPI("sd@okhdfc", "123456789009876", "hdfc", 100000, "123456", "sd");
	}

	@Test
	void testAddUpi() throws Exception {
		
		when(upiRepository.findByUpiId("sd@okhdfc")).thenReturn(null);
		when(upiRepository.save(upi)).thenReturn(upi);
		assertEquals(true, upiServices.addUpi(upi));
	}

}
