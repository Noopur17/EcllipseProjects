package com.apex.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.apex.BO.BankBO;
import com.apex.DAO.BankDAO;
import com.apex.VO.BankVO;
import com.apex.validation.BankValidationException;

public class BankInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		BankVO bvo = (BankVO)session.getAttribute("bvo");
		
		//step1 
		bvo.setBankname(request.getParameter("bankname"));
		bvo.setAccount(request.getParameter("account"));
		bvo.setSsn(request.getParameter("ssn"));
		System.out.println(bvo.getBankname());
		
		//step 2:
		//step 2a:
		String errors = "";
		BankBO bankbo = (BankBO)session.getAttribute("bankbo");
				
		try{
			/*BankDAO dao = new BankDAO();
			dao.addBankInfo(bvo);
			*/
			bankbo.addBankData(bvo, "bankInfo");
		}catch (BankValidationException ex){
			errors = ex.getErrorMessage();
		}catch (Exception e) {
			e.printStackTrace();
		}
			
		//step 2b:
		if(errors.equals("")){
			session.setAttribute("bvo", bvo);
			session.setAttribute("bankbo", bankbo);
			request.setAttribute("bvo", bvo);
			response.sendRedirect("html/success.jsp");

		}
	}
	
	
}
