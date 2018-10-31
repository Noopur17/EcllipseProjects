package com.apex.bank.registration.bo;

import java.util.ArrayList;

import com.apex.bank.registration.vo.BankVO;

public interface BankService {
	public void addBankInfo(BankVO bvo)throws Exception;
	public ArrayList<BankVO> getAllBankInfo();
	public ArrayList<BankVO> editBankInfo(String firstName);
	public int deleteBankInfo (String firstName);
}
