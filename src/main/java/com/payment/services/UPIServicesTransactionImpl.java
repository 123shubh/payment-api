package com.payment.services;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.payment.entity.TransactionByUpi;
import com.payment.entity.UPI;
import com.payment.exception.InvalidUPIDetailsException;
import com.payment.exception.LowBalanceException;
import com.payment.repository.TransactionRepositoryForUpi;
import com.payment.repository.UPIRepository;

@Service
public class UPIServicesTransactionImpl implements IUPITransactionServices {

	@Autowired
	private UPIRepository upiRepository;

	@Autowired
	private TransactionRepositoryForUpi transactionRepositoryForUpi;

	@Override
	public boolean processUPITransaction(TransactionByUpi transactionByUpi)
			throws LowBalanceException, InvalidUPIDetailsException {
		if (verifyUPIDetails(transactionByUpi)) {
			String upiId = transactionByUpi.getUpiId();
			UPI upi = upiRepository.findByUpiId(upiId);
			double transactionAmountToBePaid = transactionByUpi.getAmountToBePaid();
			double availableUPIAccountBalance = upiRepository.findByUpiId(upiId).getAccountBalance();
			if ((Double.compare(transactionAmountToBePaid, availableUPIAccountBalance) > 0)) {
				throw new LowBalanceException(
						"UPI account don't have sufficient balance,Available balance : " + availableUPIAccountBalance);
			} else {
				double newAvailableUpiAccountBalance = availableUPIAccountBalance - transactionAmountToBePaid;
				upi.setAccountBalance(newAvailableUpiAccountBalance);
				upiRepository.save(upi);
				transactionRepositoryForUpi.save(transactionByUpi);

				return true;
			}
		} else {
			return false;
		}
	}

	@Override
	public boolean verifyUPIDetails(TransactionByUpi transactionByUpi) throws InvalidUPIDetailsException {
		String upiId = transactionByUpi.getUpiId();
		UPI upi = upiRepository.findByUpiId(upiId);
		if (upiId.equals("")) {
			throw new InvalidUPIDetailsException(
					"Invalid UPI id, no upi id found in request,provided UPI Id : " + upiId);
		} else if (upi == null) {
			throw new InvalidUPIDetailsException(
					"Invalid UPI Id, could not found any match in database,provided UPI Id  : " + upiId);
		} else if (transactionRepositoryForUpi
				.findByTransactionIdForPaymentByUpi(transactionByUpi.getTransactionIdForPaymentByUpi().toLowerCase())
				.isPresent()) {
			throw new EntityExistsException(
					"Transaction with provided transaction id already exist could not proceed further,provide Transaction Id "
							+ transactionByUpi.getTransactionIdForPaymentByUpi());
		} else {
			if (!transactionByUpi.getUpiId().trim().equalsIgnoreCase(upi.getUpiId().trim())
					|| !transactionByUpi.getPasscode().trim().equalsIgnoreCase(upi.getPasscode().trim())) {
				throw new InvalidUPIDetailsException(
						"Provided data is not matching with any UPI data, provided data in transaction : "
								+ transactionByUpi);
			} else {
				return true;
			}
		}
	}

}
