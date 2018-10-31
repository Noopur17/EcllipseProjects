package com.apex.servlets;

import java.io.IOException;

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


public class ContactInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Step 1:
		
		HttpSession session = request.getSession();
		
		BankVO bvo = (BankVO)session.getAttribute("Noopur");
		
		
		
		String address = request.getParameter("address");
		
		
		bvo.setAddress(address);
		
		bvo.setCity(request.getParameter("city"));
		bvo.setState(request.getParameter("state"));
		bvo.setCountry(request.getParameter("country"));
		bvo.setPhone(request.getParameter("phone"));
		
		//Step 2: Process the data
		//2 a. Validation
		String errors = "";
		BankBO bankbo = (BankBO)session.getAttribute("bankbo");
				
		try{
			bankbo.addBankData(bvo, "contactInfo");
		}catch (BankValidationException ex){
			errors = ex.getErrorMessage();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		//Step 3 :
		if(errors.equals("")){
			
			session.setAttribute("bvo", bvo);
			session.setAttribute("bankbo", bankbo);
			
			response.sendRedirect("jsp/bankInfo.jsp");
		
		}else {
			request.setAttribute("errors", errors);
			RequestDispatcher  rd = request.getRequestDispatcher("jsp/contactInfo.jsp");
			rd.forward(request, response);
		}
		
	}

}
