package com.payment.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CreditCard {

	@Id
	private String creditCardNumber;

	private String nameOnCreditCard;

	private LocalDate creditCardExpiryDate;

	private String cvvCode;

	private String linkedAccountNumber;

	private String typeOfCreditCard;

	private double maxCreditCardLimit;

	private double creditLimitUsed;

	private double availableCreditBalance;

	public CreditCard() {
		super();
	}

	public CreditCard(String creditCardNumber, String nameOnCreditCard, LocalDate creditCardExpiryDate, String cvvCode,
			String linkedAccountNumber, String typeOfCreditCard, double maxCreditCardLimit, double creditLimitUsed,
			double availableCreditBalance) {
		super();
		this.creditCardNumber = creditCardNumber;
		this.nameOnCreditCard = nameOnCreditCard;
		this.creditCardExpiryDate = creditCardExpiryDate;
		this.cvvCode = cvvCode;
		this.linkedAccountNumber = linkedAccountNumber;
		this.typeOfCreditCard = typeOfCreditCard;
		this.maxCreditCardLimit = maxCreditCardLimit;
		this.creditLimitUsed = creditLimitUsed;
		this.availableCreditBalance = availableCreditBalance;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public String getNameOnCreditCard() {
		return nameOnCreditCard;
	}

	public void setNameOnCreditCard(String nameOnCreditCard) {
		this.nameOnCreditCard = nameOnCreditCard;
	}

	public LocalDate getCreditCardExpiryDate() {
		return creditCardExpiryDate;
	}

	public void setCreditCardExpiryDate(LocalDate creditCardExpiryDate) {
		this.creditCardExpiryDate = creditCardExpiryDate;
	}

	public String getCvvCode() {
		return cvvCode;
	}

	public void setCvvCode(String cvvCode) {
		this.cvvCode = cvvCode;
	}

	public String getLinkedAccountNumber() {
		return linkedAccountNumber;
	}

	public void setLinkedAccountNumber(String linkedAccountNumber) {
		this.linkedAccountNumber = linkedAccountNumber;
	}

	public String getTypeOfCreditCard() {
		return typeOfCreditCard;
	}

	public void setTypeOfCreditCard(String typeOfCreditCard) {
		this.typeOfCreditCard = typeOfCreditCard;
	}

	public double getMaxCreditCardLimit() {
		return maxCreditCardLimit;
	}

	public void setMaxCreditCardLimit(double maxCreditCardLimit) {
		this.maxCreditCardLimit = maxCreditCardLimit;
	}

	public double getCreditLimitUsed() {
		return creditLimitUsed;
	}

	public void setCreditLimitUsed(double creditLimitUsed) {
		this.creditLimitUsed = creditLimitUsed;
	}

	public double getAvailableCreditBalance() {
		return availableCreditBalance;
	}

	public void setAvailableCreditBalance(double availableCreditBalance) {
		this.availableCreditBalance = availableCreditBalance;
	}

	@Override
	public String toString() {
		return "CreditCard [creditCardNumber=" + creditCardNumber + ", nameOnCreditCard=" + nameOnCreditCard
				+ ", creditCardExpiryDate=" + creditCardExpiryDate + ", cvvCode=" + cvvCode + ", linkedAccountNumber="
				+ linkedAccountNumber + ", typeOfCreditCard=" + typeOfCreditCard + ", maxCreditCardLimit="
				+ maxCreditCardLimit + ", creditLimitUsed=" + creditLimitUsed + ", availableCreditBalance="
				+ availableCreditBalance + "]";
	}

}
