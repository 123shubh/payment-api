package com.payment.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.DynamicInsert;

@Entity
@DynamicInsert
public class TransactionByCreditCard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "serialIdTransactionByCreditCard", nullable = false)
	private int serialIdTransactionByCreditCard;

	private String transactionIdForPaymentByCreditCard;

	private String modeOfPayment;

	private double amountToBePaid;

	private String transactionSource;// transaction coming from which site

	private String nameOnCreditCard;

	private String creditCardNumber;

	private LocalDate creditCardExpiryDate;

	private String cvvCode;

	public TransactionByCreditCard() {
		super();
	}

	public TransactionByCreditCard(int serialIdTransactionByCreditCard, String transactionIdForPaymentByCreditCard,
			String modeOfPayment, double amountToBePaid, String transactionSource, String nameOnCreditCard,
			String creditCardNumber, LocalDate creditCardExpiryDate, String cvvCode) {
		super();
		this.serialIdTransactionByCreditCard = serialIdTransactionByCreditCard;
		this.transactionIdForPaymentByCreditCard = transactionIdForPaymentByCreditCard;
		this.modeOfPayment = modeOfPayment;
		this.amountToBePaid = amountToBePaid;
		this.transactionSource = transactionSource;
		this.nameOnCreditCard = nameOnCreditCard;
		this.creditCardNumber = creditCardNumber;
		this.creditCardExpiryDate = creditCardExpiryDate;
		this.cvvCode = cvvCode;
	}

	public int getSerialIdTransactionByCreditCard() {
		return serialIdTransactionByCreditCard;
	}

	public void setSerialIdTransactionByCreditCard(int serialIdTransactionByCreditCard) {
		this.serialIdTransactionByCreditCard = serialIdTransactionByCreditCard;
	}

	public String getTransactionIdForPaymentByCreditCard() {
		return transactionIdForPaymentByCreditCard;
	}

	public void setTransactionIdForPaymentByCreditCard(String transactionIdForPaymentByCreditCard) {
		this.transactionIdForPaymentByCreditCard = transactionIdForPaymentByCreditCard;
	}

	public String getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	public double getAmountToBePaid() {
		return amountToBePaid;
	}

	public void setAmountToBePaid(double amountToBePaid) {
		this.amountToBePaid = amountToBePaid;
	}

	public String getTransactionSource() {
		return transactionSource;
	}

	public void setTransactionSource(String transactionSource) {
		this.transactionSource = transactionSource;
	}

	public String getNameOnCreditCard() {
		return nameOnCreditCard;
	}

	public void setNameOnCreditCard(String nameOnCreditCard) {
		this.nameOnCreditCard = nameOnCreditCard;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
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

	@Override
	public String toString() {
		return "TransactionByCreditCard [serialIdTransactionByCreditCard=" + serialIdTransactionByCreditCard
				+ ", transactionIdForPaymentByCreditCard=" + transactionIdForPaymentByCreditCard + ", modeOfPayment="
				+ modeOfPayment + ", amountToBePaid=" + amountToBePaid + ", transactionSource=" + transactionSource
				+ ", nameOnCreditCard=" + nameOnCreditCard + ", creditCardNumber=" + creditCardNumber
				+ ", creditCardExpiryDate=" + creditCardExpiryDate + ", cvvCode=" + cvvCode + "]";
	}

}
