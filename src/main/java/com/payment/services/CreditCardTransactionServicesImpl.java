package com.payment.services;

import javax.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.payment.entity.CreditCard;
import com.payment.entity.TransactionByCreditCard;
import com.payment.exception.InvalidCreditCardDetailsException;
import com.payment.exception.LowBalanceException;
import com.payment.repository.CreditCardRepository;
import com.payment.repository.TransactionRepositoryForCreditCard;

@Service
public class CreditCardTransactionServicesImpl implements ICreditCardTransactionServices {

	@Autowired
	private CreditCardRepository creditCardRepository;

	@Autowired
	private TransactionRepositoryForCreditCard transactionRepository;

	@Override
	public boolean processTransaction(TransactionByCreditCard transactionByCreditCard)
			throws InvalidCreditCardDetailsException, LowBalanceException {
		if (verifyCreditCardDetails(transactionByCreditCard)) {
			String creditCardNumber = transactionByCreditCard.getCreditCardNumber().trim().replace(" ", "").replace("-",
					"");
			CreditCard creditCard = creditCardRepository.findByCreditCardNumber(creditCardNumber);
			double transactionAmountToBePaid = transactionByCreditCard.getAmountToBePaid();
			double availableCreditCardBalance = creditCard.getAvailableCreditBalance();
			if ((Double.compare(transactionAmountToBePaid, availableCreditCardBalance) > 0)) {
				throw new LowBalanceException(
						"Credit card don't have sufficient balance,Available balance : " + availableCreditCardBalance);
			} else {
				double newAvailableCreditCardBalance = availableCreditCardBalance - transactionAmountToBePaid;
				double newCreditLimitUsed = creditCard.getCreditLimitUsed() + transactionAmountToBePaid;
				creditCard.setAvailableCreditBalance(newAvailableCreditCardBalance);
				creditCard.setCreditLimitUsed(newCreditLimitUsed);
				creditCardRepository.save(creditCard);
				transactionRepository.save(transactionByCreditCard);
				return true;
			}
		} else {
			return false;
		}
	}

	@Override
	public boolean verifyCreditCardDetails(TransactionByCreditCard transactionByCreditCard)
			throws InvalidCreditCardDetailsException {
		String ccNumber = transactionByCreditCard.getCreditCardNumber();
		CreditCard creditCard = creditCardRepository.findByCreditCardNumber(ccNumber);
		if (ccNumber.trim().replace(" ", "").replace("-", "").contains("/^[A-Za-z]*$/")) {
			throw new InvalidCreditCardDetailsException(
					"Invalid credit card number, credit card contains character,provided CCNumber : " + ccNumber);
		} else if (ccNumber.equals("") || !ccNumber.matches("[0-9]{14}")) {
			// credit card support regex with 14 numeric digit card number only
			throw new InvalidCreditCardDetailsException(
					"Credit card number is not matching with any credit card patter credit card supports 14 digit only,provided CCNumber : " + ccNumber);
		} else if (creditCard == null) {
			throw new InvalidCreditCardDetailsException(
					"Invalid credit card number, could not found match in database,provided CCNumber : " + ccNumber);
		} else if (transactionRepository.findByTransactionIdForPaymentByCreditCard(
				transactionByCreditCard.getTransactionIdForPaymentByCreditCard().toLowerCase()).isPresent()) {
			throw new EntityExistsException(
					"Transaction with provided transaction id already exist could not proceed further,provide Transaction Id "
							+ transactionByCreditCard.getTransactionIdForPaymentByCreditCard());
		} else {
			if (!transactionByCreditCard.getNameOnCreditCard().trim().replace(" ", "")
					.equalsIgnoreCase(creditCard.getNameOnCreditCard().trim().replace(" ", ""))
					|| !transactionByCreditCard.getCreditCardExpiryDate().equals(creditCard.getCreditCardExpiryDate())
					|| !transactionByCreditCard.getCvvCode().equals(creditCard.getCvvCode())) {
				throw new InvalidCreditCardDetailsException(
						"Provided data is not matching with any credit card data, provided data in transaction : "
								+ transactionByCreditCard);
			} else {
				return true;
			}
		}
	}

}
