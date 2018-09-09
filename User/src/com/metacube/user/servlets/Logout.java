package com.metacube.user.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Logout extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		PrintWriter out = res.getWriter();
		
		HttpSession session=req.getSession();  
        session.invalidate();  //invalidates the session
          
        out.print("You are successfully logged out!");  
        
        req.getRequestDispatcher("index.html").include(req, res);//comes back to home page with its own request
	}
	
}
