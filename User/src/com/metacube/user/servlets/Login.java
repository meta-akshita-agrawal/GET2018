package com.metacube.user.servlets;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;


public class Login extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		HttpSession session = req.getSession();
		session.setAttribute("name", req.getParameter("email"));//sets session attribute with email
		
		req.getRequestDispatcher("Profile?visibility=visible").include(req, res);//moves to profile servlet
		
		
	}
}
