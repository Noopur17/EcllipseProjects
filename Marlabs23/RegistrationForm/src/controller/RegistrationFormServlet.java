package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegistrationFormServlet extends HttpServlet {
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		HttpSession hs=request.getSession();
		String fno= request.getParameter("fno");
		if(fno.equals("1"))
		{
			String name=request.getParameter("name");
			String fname=request.getParameter("fname");
			String mname=request.getParameter("mname");
			
			hs.setAttribute("name", name);
			hs.setAttribute("fname", fname);
			hs.setAttribute("mname", mname);
			
			response.sendRedirect("html/form2.html");
		}
		if(fno.equals("2"))
		{
			String contact=request.getParameter("contact");
			String email=request.getParameter("email");
			String address=request.getParameter("address");
			
			hs.setAttribute("contact", contact);
			hs.setAttribute("email", email);
			hs.setAttribute("address", address);
			
			response.sendRedirect("html/form3.html");

		}
		if(fno.equals("3"))
		{
			String qual=request.getParameter("qual");
			String per=request.getParameter("per");
			
			hs.setAttribute("qualification", qual);
			hs.setAttribute("percentage", per);
			
		String name=(String)hs.getAttribute("name");
		String fname=(String)hs.getAttribute("fname");
		String mname=(String)hs.getAttribute("mname");

		String contact=(String)hs.getAttribute("contact");
		String email=(String)hs.getAttribute("email");
		String address=(String)hs.getAttribute("address");


		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			PreparedStatement pst= con.prepareStatement("insert into registration values(?,?,?,?,?,?,?,?)");
			
			pst.setString(1, name);
			pst.setString(2, fname);
			pst.setString(3, mname);
			pst.setString(4, contact);
			pst.setString(5, email);
			pst.setString(6, address);
			pst.setString(7, qual);
			pst.setString(8, per);
			
			int i=pst.executeUpdate();
			
			if(i!=0)
			{
				out.println("<pre>");
				out.println("NAME="+name);
				out.println("FNAME="+fname);
				out.println("MNAME="+mname);
				out.println("CONTACT="+contact);
				out.println("EMAIL="+email);
				out.println("ADDRESS="+address);
				out.println("QUALIFICATION="+qual);
				out.println("PERCENTAGE="+per);
				out.println("</pre>");

			}
			else
			{
				out.print("REGISTRATION FAILED");
			}


		}
		catch(Exception e)
		{
			out.print("REGISTRATION FAILED"+e.getMessage());
			e.printStackTrace();

		}
		}

	
	
	
	
	}

	
}
