package com.payment.services;

import com.payment.entity.TransactionByCreditCard;
import com.payment.exception.InvalidCreditCardDetailsException;
import com.payment.exception.LowBalanceException;

public interface ICreditCardTransactionServices {
	
	public boolean processTransaction(TransactionByCreditCard transactionByCreditCard) throws InvalidCreditCardDetailsException, LowBalanceException;
	
	public boolean verifyCreditCardDetails(TransactionByCreditCard transactionByCreditCard) throws InvalidCreditCardDetailsException;

}
