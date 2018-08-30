package com.servlets;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
public class HelloServlet extends HttpServlet {
	
	public void doGet (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		String name = req.getParameter("name");
		out.println("Hello, "+ name);
		out.close();
	}
}
