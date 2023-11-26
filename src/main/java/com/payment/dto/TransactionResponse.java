package com.payment.dto;

import java.time.LocalDateTime;

public class TransactionResponse {

	private int responseCode;

	private LocalDateTime transactonResponseTime;

	private String transactionId;

	private String nameOfTransactionDoer;

	private boolean isError;

	private boolean isSuccess;

	private String responseMessage;

	public TransactionResponse() {
		super();
	}

	public TransactionResponse(int responseCode, LocalDateTime transactonResponseTime, String transactionId,
			String nameOfTransactionDoer, boolean isError, boolean isSuccess, String responseMessage) {
		super();
		this.responseCode = responseCode;
		this.transactonResponseTime = transactonResponseTime;
		this.transactionId = transactionId;
		this.nameOfTransactionDoer = nameOfTransactionDoer;
		this.isError = isError;
		this.isSuccess = isSuccess;
		this.responseMessage = responseMessage;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public LocalDateTime getTransactonResponseTime() {
		return transactonResponseTime;
	}

	public void setTransactonResponseTime(LocalDateTime transactonResponseTime) {
		this.transactonResponseTime = transactonResponseTime;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getNameOfTransactionDoer() {
		return nameOfTransactionDoer;
	}

	public void setNameOfTransactionDoer(String nameOfTransactionDoer) {
		this.nameOfTransactionDoer = nameOfTransactionDoer;
	}

	public boolean isError() {
		return isError;
	}

	public void setError(boolean isError) {
		this.isError = isError;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	@Override
	public String toString() {
		return "TransactionResponse [responseCode=" + responseCode + ", transactonResponseTime="
				+ transactonResponseTime + ", transactionId=" + transactionId + ", nameOfTransactionDoer="
				+ nameOfTransactionDoer + ", isError=" + isError + ", isSuccess=" + isSuccess + ", responseMessage="
				+ responseMessage + "]";
	}

}
