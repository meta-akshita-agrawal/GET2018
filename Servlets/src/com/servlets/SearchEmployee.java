package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.Connection;

public class SearchEmployee extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private static final String SEARCH_QUERY="select * from employee where `First Name`=? and `Last Name`=?;";
	
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
			psmt = conn.prepareStatement(SEARCH_QUERY);
			
			//bind variables to request parameters
			psmt.setString(1, req.getParameter("firstName"));
			psmt.setString(2,req.getParameter("lastName"));
			
			rs = psmt.executeQuery();
			
			//writes HTML to the response
			out.println("<html><body>");
			out.println("<table border=1>");
			out.println("<tr><th>First Name</th><th>Last Name</th><th>Email</th><th>Age</th><tr>");
			while (rs.next()) {
                 String firstName = rs.getString("First Name");
                 String lastName = rs.getString("Last Name");
                 String email = rs.getString("Email");
                 int age = rs.getInt("Age"); 
                 out.println("<tr><td>" + firstName + "</td><td>" + lastName + "</td><td>" + email + "</td><td>" + age + "</td></tr>"); 
			}
			out.println("</table>");
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