package com.metacube.user.servlets;

import java.io.*;
import java.util.Enumeration;

import javax.servlet.ServletException;  
import javax.servlet.http.*;

import com.oreilly.servlet.MultipartRequest;
  
public class Upload extends HttpServlet {  
  

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)  
	    throws ServletException, IOException {  
	  
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		
		int maxSize = 10000000;
		
		MultipartRequest m=new MultipartRequest(request,"C:\\Users\\hp\\git\\GET2018\\eadAssignment4\\User\\WebContent\\images", maxSize);  
		
		request.getRequestDispatcher("Profile?visibility=visible").include(request, response);
		
		
	}  
}  