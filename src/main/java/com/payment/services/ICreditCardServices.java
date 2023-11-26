package com.payment.services;

import com.payment.entity.CreditCard;

public interface ICreditCardServices {

	public CreditCard getCreditCardByCreditCardNumber(String creditCardNumber);

	public boolean addCreditCard(CreditCard creditCard) throws Exception;

}
