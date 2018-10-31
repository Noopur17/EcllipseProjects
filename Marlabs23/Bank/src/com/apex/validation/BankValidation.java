package com.apex.validation;

import com.apex.interfaces.ErrorMessage;



public class BankValidation {

	
	public String validateFirstName(String fname){
		if (checkFieldBlank(fname)){
			return ErrorMessage.FIRST_NAME_IS_BLANK;
		}	
		return "";
	}
	public String validateLastName(String lname){
		if (checkFieldBlank(lname)){
			return ErrorMessage.LAST_NAME_IS_BLANK;
		}	
		return "";
	}
	public String validateGender(String gender){
		if (checkFieldBlank(gender)){
			return ErrorMessage.GENDER_NOT_SELECTED;
		}	
		return "";
	}
	public String validateAddress(String address){
		if (checkFieldBlank(address)){
			return ErrorMessage.ADDRESS_IS_BLANK;
		}	
		return "";
	}
	public String validateCity(String city){
		if (checkFieldBlank(city)){
			return ErrorMessage.CITY_IS_BLANK;
		}	
		return "";
	}
	public String validateState(String state){
		if (checkFieldBlank(state)){
			return ErrorMessage.STATE_IS_BLANK;
		}	
		return "";
	}
	public String validateCountry(String country){
		if (checkFieldBlank(country)){
			return ErrorMessage.COUNTRY_IS_BLANK;
		}	
		return "";
	}
	public String validatePhone(String phone){
		if (checkFieldBlank(phone)){
			return ErrorMessage.PHONE_IS_BLANK;
		}	
		return "";
	}
	public String validateBankName(String bankname){
		if (checkFieldBlank(bankname)){
			return ErrorMessage.BANK_NAME_IS_BLANK;
		}	
		return "";
	}
	public String validateAccount(String account){
		if (checkFieldBlank(account)){
			return ErrorMessage.ACCOUNT_IS_BLANK;
		}	
		return "";
	}
	public String validateSSN(String ssn){
		if (checkFieldBlank(ssn)){
			return ErrorMessage.SSN_IS_BLANK;
		}	
		return "";
	}
	
	private boolean checkFieldBlank(String fieldValue) {
		return fieldValue == null || fieldValue.length() == 0;
	}
}
