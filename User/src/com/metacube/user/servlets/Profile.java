package com.metacube.user.servlets;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class Profile extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
	
		PrintWriter out = res.getWriter();
		
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
						out.println("<td><input id='firstName' type='text' value=" + req.getParameter("FirstName") + "disabled></td>");
					out.println("</tr>");
					out.println("<tr>");
						out.println("<td>Last Name</td>");
						out.println("<td><input id='lastName' type='text' value=" + req.getParameter("Last Name") + "disabled></td>");
					out.println("</tr>");
					out.println("<tr>");
						out.println("<td>Email</td>");
						out.println("<td><input id='email' type='text' value=" + req.getParameter("Email") + "disabled></td>");
					out.println("</tr>");
					out.println("<tr>");
						out.println("<td>Password</td>");
						out.println("<td><input id='password' type='password' value=" + req.getParameter("password") + "disabled></td>");
					out.println("</tr>");
					out.println("<tr>");
						out.println("<td>Contact Number</td>");
						out.println("<td><input id='contactNumber' type='text' value=" + req.getParameter("Contact Number") +"disabled></td>");
					out.println("</tr>");
					out.println("<tr>");
						out.println("<td>Company/Organization</td>");
						out.println("<td><input id='company' type='text' value=" + req.getParameter("Company") +"disabled></td>");
					out.println("</tr>");
					out.println("<tr>");
						out.println("<td><input type='button' value='Edit' onclick=enableAll()></td>");
						out.println("<td><input type='submit' value='Save'></td>");
					out.println("</tr>");
				out.println("</table>");
			out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
}
