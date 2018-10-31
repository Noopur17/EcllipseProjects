package com.apex.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.apex.BO.BankBO;
import com.apex.VO.BankVO;
import com.apex.validation.BankValidationException;


public class PersonalInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//step 1: read the data
		BankVO bvo = new BankVO();
		
		String fname = request.getParameter("fname");
		
		bvo.setFname(fname);
		bvo.setLname(request.getParameter("lname"));
		bvo.setGender(request.getParameter("gender"));
		
		//Step 2: Process the data
		String errors = "";
		BankBO bankbo = new BankBO();
		
		try{
			bankbo.addBankData(bvo, "personalInfo");
			
		}catch (BankValidationException ex){
			errors = ex.getErrorMessage();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		//step 3: response back
		if(errors.equals("")){
			
			request.getSession().setAttribute("bankbo", bankbo);
			request.getSession().setAttribute("Noopur", bvo);
			
			response.sendRedirect("jsp/contactInfo.jsp");
			
		}else {
			request.setAttribute("errors", errors);
			
			
			RequestDispatcher  rd = request.getRequestDispatcher("jsp/personalInfo.jsp");
			rd.forward(request, response);
		}			
		
	}
}
