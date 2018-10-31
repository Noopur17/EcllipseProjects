package com.apex.bank.registration.dao;

import java.sql.Connection;
import java.util.ArrayList;

import com.apex.bank.registration.vo.BankVO;


public interface BankDAO {
	public Connection getConnection() throws Exception;
	public void addBankInfo(BankVO bvo)throws Exception;
	public ArrayList<BankVO> getAllBankInfo();
	public ArrayList<BankVO> editBankInfo(String firstName);
	public int deleteBankInfo (String firstName);
}
