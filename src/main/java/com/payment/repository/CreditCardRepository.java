package com.payment.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payment.entity.CreditCard;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, String> {

	public CreditCard findByCreditCardNumber(String creditCardNumber);
	
}
