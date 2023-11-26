package com.payment.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UPI {

	@Id
	private String upiId;

	private String linkedAccountNumber;

	private String linkedBankName;

	private double accountBalance;

	private String passcode;

	private String upiHolderName;

	public UPI() {
		super();
	}

	public UPI(String upiId, String linkedAccountNumber, String linkedBankName, double accountBalance, String passcode,
			String upiHolderName) {
		super();
		this.upiId = upiId;
		this.linkedAccountNumber = linkedAccountNumber;
		this.linkedBankName = linkedBankName;
		this.accountBalance = accountBalance;
		this.passcode = passcode;
		this.upiHolderName = upiHolderName;
	}

	public String getUpiId() {
		return upiId;
	}

	public void setUpiId(String upiId) {
		this.upiId = upiId;
	}

	public String getLinkedAccountNumber() {
		return linkedAccountNumber;
	}

	public void setLinkedAccountNumber(String linkedAccountNumber) {
		this.linkedAccountNumber = linkedAccountNumber;
	}

	public String getLinkedBankName() {
		return linkedBankName;
	}

	public void setLinkedBankName(String linkedBankName) {
		this.linkedBankName = linkedBankName;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
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
		return "UPI [upiId=" + upiId + ", linkedAccountNumber=" + linkedAccountNumber + ", linkedBankName="
				+ linkedBankName + ", accountBalance=" + accountBalance + ", passcode=" + passcode + ", upiHolderName="
				+ upiHolderName + "]";
	}

}
