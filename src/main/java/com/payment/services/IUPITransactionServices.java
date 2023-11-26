package com.payment.services;

import com.payment.entity.TransactionByUpi;
import com.payment.exception.InvalidUPIDetailsException;
import com.payment.exception.LowBalanceException;

public interface IUPITransactionServices {

	public boolean processUPITransaction(TransactionByUpi transactionByUpi)
			throws LowBalanceException, InvalidUPIDetailsException;

	public boolean verifyUPIDetails(TransactionByUpi transactionByUpi) throws InvalidUPIDetailsException;

}
