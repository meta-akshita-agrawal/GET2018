package com.metacube.user.servlets;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.metacube.user.facade.UserFacade;
import com.metacube.user.pojo.User;

public class Profile extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	UserFacade userFacade = UserFacade.getInstance();

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
	
		PrintWriter out = res.getWriter();
		
		User user = userFacade.getUserByEmail(req.getParameter("email"));
		
		System.out.println(req.getParameter("visibility") + "ashvcjjkbdc");
		
		out.println("<html>");
		out.println("<head>");
			out.println("<table>");
				out.println("<script>");
					out.println("function enable(id){");
						out.println("document.getElementById(id).disabled=false;");
					out.println("}");
					out.println("function enableAll(){");
						out.println("enable('firstName');");
						out.println("enable('lastName');");
						out.println("enable('email');");
						out.println("enable('password');");
						out.println("enable('contactNumber');");
						out.println("enable('company');");
					out.println("}");
				out.println("</script>");
				out.println("<tr>");
					out.println("<td><img src=\"images/default.jpeg\"></td>");
					out.println("<td><a href=\"Logout\">Logout</a></td>");					
					out.println("<td><a href=\"Friends?email=" + user.getEmail() + "\">Friends</a></td>");
				out.println("</tr>");
			out.println("</table>");
			out.println("<hr>");
		out.println("</head>");
		out.println("<body>");
			out.println("<br />");
			out.println("<form action=\"Update\">");
				out.println("<table>");
					out.println("<tr>");
						out.println("<td>First Name</td>");                                                                              
						out.println("<td><input id='firstName' name='firstName' type='text' value=" + user.getFirstName() + " disabled></td>");
					out.println("</tr>");
					out.println("<tr>");
						out.println("<td>Last Name</td>");
						out.println("<td><input id='lastName' name='lastName' type='text' value=" + user.getLastName() + " disabled></td>");
					out.println("</tr>");
					out.println("<tr>");
						out.println("<td>Email</td>"); 
						out.println("<td><input id='email' name='email' type='text' value=" + user.getEmail() + " disabled></td>");
					out.println("</tr>");
					out.println("<tr>");
						out.println("<td>Password</td>");
						out.println("<td><input id='password' name='password' type='password' value=" + user.getPassword() + " disabled></td>");
					out.println("</tr>");
					out.println("<tr>");
						out.println("<td>Contact Number</td>");
						out.println("<td><input id='contactNumber' name='contactNumber' type='text' value=" + user.getContactNumber() +" disabled></td>");
					out.println("</tr>");
					out.println("<tr>");
						out.println("<td>Company/Organization</td>");
						out.println("<td><input id='company' type='text' name='companyName' value=" + user.getCompanyName() +" disabled></td>");
					out.println("</tr>");
					out.println("<tr>");
						out.println("<td><input type='button' value='Edit' onclick=enableAll() style='visibility:" + req.getParameter("visibility") + "'></td>");
						out.println("<td><input type='submit' value='Save' style=visibility:" + req.getParameter("visibility") +"></td>");
					out.println("</tr>");
				out.println("</table>");
			out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}
}
