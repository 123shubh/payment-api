package com.payment.services;

import javax.persistence.EntityExistsException;
import org.hibernate.cfg.beanvalidation.IntegrationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.NotAcceptableStatusException;
import com.payment.entity.CreditCard;
import com.payment.exception.InvalidCreditCardDetailsException;
import com.payment.repository.CreditCardRepository;

@Service
public class CreditCardServicesImpl implements ICreditCardServices {

	@Autowired
	private CreditCardRepository creditCardRepository;

	@Override
	public CreditCard getCreditCardByCreditCardNumber(String creditCardNumber) {
		return creditCardRepository.findByCreditCardNumber(creditCardNumber);
	}

	@Override
	public boolean addCreditCard(CreditCard creditCard) throws Exception {

		if (creditCard != null) {
			String ccNumber = creditCard.getCreditCardNumber();
			if (creditCard.getCreditCardNumber().isEmpty() || creditCard.getCreditCardExpiryDate() == null
					|| creditCard.getNameOnCreditCard().isEmpty() || creditCard.getCvvCode().isEmpty()
					|| creditCard.getLinkedAccountNumber().isEmpty() || creditCard.getTypeOfCreditCard().isEmpty()
					|| creditCard.getMaxCreditCardLimit() == 0) {
				throw new NotAcceptableStatusException("Invalid information provided");
			} else if (creditCardRepository.findByCreditCardNumber(creditCard.getCreditCardNumber()) != null) {
				throw new EntityExistsException("Credit card with provided credit card number already exist :"
						+ creditCard.getCreditCardNumber());
			} else if (ccNumber.equals("") || !ccNumber.matches("[0-9]{14}")) {
				// credit card support regex with 14 numeric digit card number only
				throw new InvalidCreditCardDetailsException(
						"Credit card number is not matching with any credit card patter credit card supports 14 digit only,provided CCNumber : " + ccNumber);
			} 
			else {
				// for now no bank account table created no validation for that
				creditCard.setAvailableCreditBalance((creditCard.getMaxCreditCardLimit()));
				try {
					creditCardRepository.save(creditCard);
				} catch (Exception e) {
					throw new IntegrationException(e.getLocalizedMessage());
				}
				return true;
			}
		}
		return false;
		
	}

}
