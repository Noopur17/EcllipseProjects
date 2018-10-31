package com.apex.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.apex.VO.BankVO;

public class BankDAO {

	public BankDAO() {
		super();
	}
	
	public Connection getConnection() throws Exception{
		
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
	
public void addBankInfo(BankVO bvo)throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		int datainserted = 0;
		try{
			con = getConnection();
			
			pstmt = con.prepareStatement("insert into bank values (?,?,?,?,?,?,?,?,?,?,?)");
			
			pstmt.setString(1, bvo.getFname());
			pstmt.setString(2, bvo.getLname());
			pstmt.setString(3, bvo.getGender());
			
			pstmt.setString(4, bvo.getAddress());
			pstmt.setString(5, bvo.getCity());
			pstmt.setString(6, bvo.getState());
			pstmt.setString(7, bvo.getCountry());
			pstmt.setString(8, bvo.getPhone());
			
			pstmt.setString(9, bvo.getBankname());
			pstmt.setString(10, bvo.getAccount());
			pstmt.setString(11, bvo.getSsn());
			
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
	
public ArrayList<BankVO> getAllBankInfo(){
		ArrayList<BankVO> list = new ArrayList<BankVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = getConnection();
			pstmt = con.prepareStatement("select * from bank");
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()){
				BankVO bvo = new BankVO();
				
				bvo.setFname(rs.getString("fname"));
				bvo.setFname(rs.getString("lname"));
				bvo.setFname(rs.getString("gender"));
				bvo.setFname(rs.getString("address"));
				bvo.setFname(rs.getString("city"));
				bvo.setFname(rs.getString("state"));
				bvo.setFname(rs.getString("country"));
				bvo.setFname(rs.getString("phone"));
				bvo.setFname(rs.getString("bankname"));
				bvo.setFname(rs.getString("account"));
				bvo.setFname(rs.getString("ssn"));
				
				list.add(bvo);
				pstmt.close();
				con.close();
				
			}

		}catch (Exception e) {
				System.out.println(e);
		}
		
		return list;
	}
	
public ArrayList<BankVO> editBankInfo(String fname){
		ArrayList<BankVO> list = new ArrayList<BankVO>();
		try{
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from bank where fname = '" + fname + "' ");
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()){
				BankVO bvo = new BankVO();
				
				bvo.setFname(rs.getString("fname"));
				bvo.setFname(rs.getString("lname"));
				bvo.setFname(rs.getString("gender"));
				bvo.setFname(rs.getString("address"));
				bvo.setFname(rs.getString("city"));
				bvo.setFname(rs.getString("state"));
				bvo.setFname(rs.getString("country"));
				bvo.setFname(rs.getString("phone"));
				bvo.setFname(rs.getString("bankname"));
				bvo.setFname(rs.getString("account"));
				bvo.setFname(rs.getString("ssn"));
				
				list.add(bvo);
			}
		}catch (Exception e) {
				System.out.println(e);
		}
		return list;
	}
	
public int deleteBankInfo (String fname){
		int i = 0;
		try{
			Connection con = getConnection();
			
			PreparedStatement pstmt = con.prepareStatement("delete from bank where fname = '" + fname + "' ");
			i = pstmt.executeUpdate();
			
			con.close();
		}catch (Exception e){
			System.out.println(e);
		}
		return i;
		
	}
}
