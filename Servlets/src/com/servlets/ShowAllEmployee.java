package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

import jdbc.Connection;

public class ShowAllEmployee extends HttpServlet{

	private static final long serialVersionUID = 1L;
	static final String GETALL_QUERY = "select * from employee;";

	/**
	 * Handles request coming from HTML form
	 * @param req, request
	 * @param res, response after submitting HTML form
	 */
	public void doGet (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		
		java.sql.Connection conn=null;
		PreparedStatement psmt =null;
		ResultSet rs=null;
		
		try {
			
			conn = Connection.getConnection();//Allocate a database 'Connection' object
			psmt = conn.prepareStatement(GETALL_QUERY);
			
			rs = psmt.executeQuery();
			out.println("<html><body>");
			out.println("<table border=1>");
			out.println("<tr><th>First Name</th><th>Last Name</th><th>Email</th><th>Age</th><tr>");
			while (rs.next()) {
                 String firstName = rs.getString("First Name");
                 String lastName = rs.getString("Last Name");
                 String email = rs.getString("Email");
                 int age = rs.getInt("Age");
                 
                 out.println("<tr>");
                 out.println("<form action=\"UpdateDetails\">");
                 out.println("<td>" + firstName + "</td><td>" + lastName + "</td><td>" + email + "</td><td>" + age + "</td>");
                 out.println("<td>" + "<input type='hidden' name='email' value=" + email + " />" + "</td>");
                 out.println("<td>" + "<input type='submit' value='Update' />" + "</td>");
                 out.println("</form></tr>");
			}
			out.println("</table>");
			out.println("</form>");
			out.println("</body></html>");
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
				psmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		RequestDispatcher requestdispatch = req.getRequestDispatcher("index.html");
		requestdispatch.include(req, res);
		out.close();
	}
	

}