package com.apex.validation;

public class BankValidationException extends Exception {

	private String errorMessage;

	public BankValidationException(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
}
