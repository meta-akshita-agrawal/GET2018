package com.metacube.user.servlets;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;


public class Login extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		HttpSession session = req.getSession();
		session.setAttribute("name", req.getParameter("Email"));
		
		req.getRequestDispatcher("Profile").include(req, res);
		
		
	}
}
