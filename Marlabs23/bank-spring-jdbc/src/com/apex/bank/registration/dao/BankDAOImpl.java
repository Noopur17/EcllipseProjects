package com.apex.bank.registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.apex.bank.registration.vo.BankVO;

@Repository
public class BankDAOImpl implements BankDAO {

	@Override
	public Connection getConnection() throws Exception {
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		
		}catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		
		}catch(Exception e) {
		   e.printStackTrace();
		   throw e;
		}
		return con;
	}

	@Override
	public void addBankInfo(BankVO bvo) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		int datainserted = 0;
		try{
			con = getConnection();
			
			pstmt = con.prepareStatement("insert into user values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, bvo.getId());
			pstmt.setString(2, bvo.getFirstName());
			pstmt.setString(3, bvo.getMiddleName());
			pstmt.setString(4, bvo.getLastName());
			pstmt.setString(5, bvo.getGender());
			pstmt.setString(6, bvo.getAddress());
			pstmt.setString(7, bvo.getCity());
			pstmt.setString(8, bvo.getState());
			pstmt.setString(9, bvo.getCountry());
			pstmt.setString(10, bvo.getPhone());
			pstmt.setString(11, bvo.getBankName());
			pstmt.setString(12, bvo.getAccountNumber());
			pstmt.setString(13, bvo.getSsn());
			
			datainserted = pstmt.executeUpdate();
			if(datainserted!=0){
				System.out.println("Data insserted successfully");
				
			}
			else{
				System.out.println("gadbad with data");
			}
		}catch (SQLException sqle) {
			   sqle.printStackTrace();
			   throw sqle;
		}catch(Exception e) {
			   e.printStackTrace();
			   throw e;
		}
		finally {
			pstmt.close();
			con.close();
		}
		return;
		
	}

	@Override
	public ArrayList<BankVO> getAllBankInfo() {
		ArrayList<BankVO> list = new ArrayList<BankVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = getConnection();
			pstmt = con.prepareStatement("select * from user");
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()){
				BankVO bvo = new BankVO();
				
				bvo.setFirstName(rs.getString("firstName"));
				bvo.setMiddleName(rs.getString("middleNname"));
				bvo.setLastName(rs.getString("lastName"));
				bvo.setGender(rs.getString("gender"));
				bvo.setAddress(rs.getString("address"));
				bvo.setCity(rs.getString("city"));
				bvo.setState(rs.getString("state"));
				bvo.setCountry(rs.getString("country"));
				bvo.setPhone(rs.getString("phone"));
				bvo.setBankName(rs.getString("bankName"));
				bvo.setAccountNumber(rs.getString("accountNumber"));
				bvo.setSsn(rs.getString("ssn"));
				
				list.add(bvo);
				pstmt.close();
				con.close();
				
			}

		}catch (Exception e) {
				System.out.println(e);
		}
		
		return list;
	}

	@Override
	public ArrayList<BankVO> editBankInfo(String firstName) {
		ArrayList<BankVO> list = new ArrayList<BankVO>();
		try{
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from user where firstName = '" + firstName + "' ");
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()){
				BankVO bvo = new BankVO();
				
				bvo.setFirstName(rs.getString("firstName"));
				bvo.setMiddleName(rs.getString("middleNname"));
				bvo.setLastName(rs.getString("lastName"));
				bvo.setGender(rs.getString("gender"));
				bvo.setAddress(rs.getString("address"));
				bvo.setCity(rs.getString("city"));
				bvo.setState(rs.getString("state"));
				bvo.setCountry(rs.getString("country"));
				bvo.setPhone(rs.getString("phone"));
				bvo.setBankName(rs.getString("bankName"));
				bvo.setAccountNumber(rs.getString("accountNumber"));
				bvo.setSsn(rs.getString("ssn"));
				
				
				list.add(bvo);
			}
		}catch (Exception e) {
				System.out.println(e);
		}
		return list;
	}

	@Override
	public int deleteBankInfo(String firstName) {
		int i = 0;
		try{
			Connection con = getConnection();
			
			PreparedStatement pstmt = con.prepareStatement("delete from user where firstName = '" + firstName + "' ");
			i = pstmt.executeUpdate();
			
			con.close();
		}catch (Exception e){
			System.out.println(e);
		}
		return i;
	}

}
