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
			out.println("<script>");
				out.println("function enable(id){");
					out.println("document.getElementById(id).disabled=false;");
				out.println("}");
				out.println("function enableAll(){");//function to enable disable fields on click of edit button
					out.println("enable('firstName');");
					out.println("enable('lastName');");
					out.println("enable('email');");
					out.println("enable('password');");
					out.println("enable('contactNumber');");
					out.println("enable('company');");
				out.println("}");
			out.println("</script>");
			out.println("<table width=100%>");
				out.println("<tr>");
					if(req.getParameter("visibility").equals("hidden")) {
						out.println("<td><a href='Upload.html?email=" + req.getParameter("email") + "'><img src=\"images/default.png\" height=100px></td>");//shows default image in case of first login
					}
					else {
						out.println("<td><a href='Upload.html?email=" + req.getParameter("email")+ "'><img src=\"images/" + req.getParameter("email") + ".png\" height=100px></td>");//else image with email name
					}
					out.println("<td align='right' style=font-size:20px valign=bottom><a href=\"Logout\">Logout</a> <a href=\"Friends?email=" + user.getEmail() + "\">Friends</a></td>");					
				out.println("</tr>");
			out.println("</table>");
			out.println("<hr>");
		out.println("</head>");
		out.println("<body>");
			out.println("<br />");
			out.println("<form action=\"Update\">");
				out.println("<table align='center' cellspacing=10px>");
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
					if(!req.getParameter("visibility").equals("hidden")) {
					out.println("<tr>");
						out.println("<td>Password</td>");
						out.println("<td><input id='password' name='password' type='password' value=" + user.getPassword() + " disabled></td>");
					out.println("</tr>");
					}
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
