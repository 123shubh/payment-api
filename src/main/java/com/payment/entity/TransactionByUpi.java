package com.payment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TransactionByUpi {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "serialIdTransactionByUpi", nullable = false)
	private int serialIdTransactionByUpi;

	private String transactionIdForPaymentByUpi;

	private String modeOfPayment;

	private double amountToBePaid;

	private String transactionSource;// transaction coming from which site

	private String upiId;

	private String passcode;
	
	private String upiHolderName;

	public TransactionByUpi() {
		super();
	}

	public TransactionByUpi(int serialIdTransactionByUpi, String transactionIdForPaymentByUpi, String modeOfPayment,
			double amountToBePaid, String transactionSource, String upiId, String passcode, String upiHolderName) {
		super();
		this.serialIdTransactionByUpi = serialIdTransactionByUpi;
		this.transactionIdForPaymentByUpi = transactionIdForPaymentByUpi;
		this.modeOfPayment = modeOfPayment;
		this.amountToBePaid = amountToBePaid;
		this.transactionSource = transactionSource;
		this.upiId = upiId;
		this.passcode = passcode;
		this.upiHolderName = upiHolderName;
	}

	public int getSerialIdTransactionByUpi() {
		return serialIdTransactionByUpi;
	}

	public void setSerialIdTransactionByUpi(int serialIdTransactionByUpi) {
		this.serialIdTransactionByUpi = serialIdTransactionByUpi;
	}

	public String getTransactionIdForPaymentByUpi() {
		return transactionIdForPaymentByUpi;
	}

	public void setTransactionIdForPaymentByUpi(String transactionIdForPaymentByUpi) {
		this.transactionIdForPaymentByUpi = transactionIdForPaymentByUpi;
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

	public String getUpiId() {
		return upiId;
	}

	public void setUpiId(String upiId) {
		this.upiId = upiId;
	}

	public String getPasscode() {
		return passcode;
	}

	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}

	public String getUpiHolderName() {
		return upiHolderName;
	}

	public void setUpiHolderName(String upiHolderName) {
		this.upiHolderName = upiHolderName;
	}

	@Override
	public String toString() {
		return "TransactionByUpi [serialIdTransactionByUpi=" + serialIdTransactionByUpi
				+ ", transactionIdForPaymentByUpi=" + transactionIdForPaymentByUpi + ", modeOfPayment=" + modeOfPayment
				+ ", amountToBePaid=" + amountToBePaid + ", transactionSource=" + transactionSource + ", upiId=" + upiId
				+ ", passcode=" + passcode + ", upiHolderName=" + upiHolderName + "]";
	}

	

}
