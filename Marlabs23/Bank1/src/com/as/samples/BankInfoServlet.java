package com.as.samples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BankInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Step 1. Read the Data
		String bankName = request.getParameter("bankName");
		String accountNumber = request.getParameter("accountNumber");
		String ssn = request.getParameter("ssn");
		
				
				
		//Step 2. Process the data
			
		// Step 3. Response
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>My Second Web</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("</br>bankName: "+ bankName);
		out.println("</br>account NUmber: "+ accountNumber);
		out.println("</br>SSn: "+ ssn);
		out.println("</body>");
		out.println("</html>");	
	}

}
