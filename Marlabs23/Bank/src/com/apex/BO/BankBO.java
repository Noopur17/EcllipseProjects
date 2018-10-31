package com.apex.BO;

import java.util.ArrayList;

import com.apex.DAO.BankDAO;
import com.apex.VO.BankVO;
import com.apex.validation.BankValidation;
import com.apex.validation.BankValidationException;

public class BankBO {
	BankDAO bankdao = new BankDAO();
	public BankBO() {
		super();
	}

	public void addBankData(BankVO bvo, String name) throws BankValidationException, Exception {

		
		StringBuilder allMessage = new StringBuilder();
		BankValidation validation = new BankValidation();

		// Step 2:a - validation
		if (name == "personalInfo") {

			String error = validation.validateFirstName(bvo.getFname());
			allMessage.append(error);

			error = validation.validateLastName(bvo.getLname());
			allMessage.append(error);

			error = validation.validateGender(bvo.getGender());
			allMessage.append(error);

			if (allMessage.length() != 0) {
				BankValidationException validationException = new BankValidationException(allMessage.toString());
				throw validationException;
			}
		} else if (name == "contactInfo") {
			String error = validation.validateAddress(bvo.getAddress());
			allMessage.append(error);

			error = validation.validateCity(bvo.getCity());
			allMessage.append(error);

			error = validation.validateState(bvo.getState());
			allMessage.append(error);

			error = validation.validateCountry(bvo.getCountry());
			allMessage.append(error);

			error = validation.validatePhone(bvo.getPhone());
			allMessage.append(error);

			if (allMessage.length() != 0) {
				BankValidationException validationException = new BankValidationException(allMessage.toString());
				throw validationException;
			}
		} else if (name == "bankInfo") {
			String error = validation.validateFirstName(bvo.getBankname());
			allMessage.append(error);

			error = validation.validateLastName(bvo.getAccount());
			allMessage.append(error);

			error = validation.validateGender(bvo.getSsn());
			allMessage.append(error);

			if (allMessage.length() == 0) {

				bankdao.addBankInfo(bvo);
				
				
			} else {
				BankValidationException validationException = new BankValidationException(allMessage.toString());
				throw validationException;
			}
		}

	}

	public ArrayList<BankVO> getAllBankData() {
		return bankdao.getAllBankInfo();
	}

	public  ArrayList<BankVO> editBankInfo(String fname){
		return bankdao.editBankInfo(fname);
	}
	public int deleteBankInfo (String fname){
		return bankdao.deleteBankInfo(fname);
	}
}
