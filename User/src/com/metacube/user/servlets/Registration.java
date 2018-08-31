package com.metacube.user.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.metacube.user.enums.Status;
import com.metacube.user.facade.UserFacade;
import com.metacube.user.pojo.User;




public class Registration extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	UserFacade userFacade = UserFacade.getInstance();

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		PrintWriter out = res.getWriter();
	
		
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String contactNumber = req.getParameter("contactNumber");
		String companyName = req.getParameter("companyName");
		
		Status insertionStatus = userFacade.insert(new User(firstName,lastName,email,password,contactNumber,companyName));
		
		if(insertionStatus == Status.INSERTED){
			out.println("Registration successfull");
			HttpSession session = req.getSession();
			session.setAttribute("name", email);
			req.getRequestDispatcher("Profile").include(req, res);
		}
		else{
			out.println("Error!");
			req.getRequestDispatcher("index.html").include(req,res);
		}
		
		
		
		out.close();
	}
	
}
